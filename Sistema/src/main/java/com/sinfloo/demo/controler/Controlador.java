package com.sinfloo.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinfloo.demo.interfaceService.IpersonaService;
import com.sinfloo.demo.modelo.Persona;



@Controller
@RequestMapping
public class Controlador {
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/")
	public String listarInicio(Model model) {
		List<Persona>personas=service.listar();
		model.addAttribute("personas",personas);
		return "index";
	}
	
	@GetMapping("/api/pagos")
	public String listar(Model model) {
		List<Persona>personas=service.listar();
		model.addAttribute("personas",personas);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona",new Persona());
		return "form";
	}
	@PostMapping("/save")
	public String save(@Validated Persona p, Model model,  RedirectAttributes attribute) {
		int resultado;
		int valor_cancelado1 = p.getValor_cancelado();
		int valor_pagado1 = p.getValor_pagado();
		
		String fecha = p.getFecha_pago(); 
		int mes=1;
		if (fecha != null) {
			char mesParte1 = fecha.charAt (8); 
			char mesParte2 = fecha.charAt (9);
			String mess = Character.toString(mesParte1) + Character.toString(mesParte2);
			mes = Integer.parseInt(mess);
			System.out.println(fecha +" "+ mes);
		}
		
		if (valor_cancelado1 == 0) {
			attribute.addFlashAttribute("success","Arrendatario creado con exito");
			resultado =  valor_pagado1;
		}else {
			if (mes%2 == 0 ) {
				resultado =  valor_pagado1;
				attribute.addFlashAttribute("success","lo siento pero no se puede recibir el pago por decreto de administración");
			}else {
				resultado =  valor_pagado1 - valor_cancelado1;
				if(resultado == 0) {
					attribute.addFlashAttribute("success","Gracias por pagar todo su arriendo");
				}else{
					attribute.addFlashAttribute("success","gracias por tu abono, sin embargo recuerda que te hace falta pagar "+ resultado);
				}
			}
		}
		
		p.setValor_pagado(resultado);
		service.save(p);
		
		
		
		return "redirect:/api/pagos";
	}
	@GetMapping("/api/pagos/{id_arrendatario}")
	public String editar(@PathVariable int id_arrendatario, Model model) {
		Optional<Persona>persona=service.listarId(id_arrendatario);
	
		model.addAttribute("persona", persona);
		return "formPago";
	}
	@GetMapping("/eliminar/{id_arrendatario}")
	public String delete(Model model, @PathVariable int id_arrendatario) {
		service.delete(id_arrendatario);
		return "redirect:/";
	}
	
}
