package com.sinfloo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.demo.interfaceService.IpersonaService;
import com.sinfloo.demo.interfaces.IPersona;
import com.sinfloo.demo.modelo.Persona;

@Service
public class PersonaService implements IpersonaService{
	@Autowired
	private IPersona data;
	@Override
	public List<Persona> listar() {
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id_arrendatario) {
		
		return data.findById(id_arrendatario);
	}

	@Override
	public int save(Persona p) {
		int res=0;
		Persona persona=data.save(p);
		if(!persona.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public void delete(int id_arrendatario) {
		data.deleteById(id_arrendatario);
		
	}
	
}
