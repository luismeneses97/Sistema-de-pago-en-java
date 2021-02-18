package com.sinfloo.demo.modelo;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagos")
public class Persona {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_arrendatario;
	private String codigo_inmueble;
	private String fecha_pago;
	private int valor_pagado = 1000000;
	private int valor_cancelado;
	public Persona(){
		
	}
	public Persona(int id_arrendatario, String codigo_inmueble, String fecha_pago, int valor_pagado, int valor_cancelado) {
		super();
		this.id_arrendatario = id_arrendatario;
		this.codigo_inmueble = codigo_inmueble;
		this.fecha_pago = fecha_pago;
		this.valor_pagado = valor_pagado;
		this.valor_cancelado = valor_cancelado;
	}
	
	
	public int getValor_cancelado() {
		return valor_cancelado;
	}
	public void setValor_cancelado(int valor_cancelado) {
		this.valor_cancelado = valor_cancelado;
	}
	public int getValor_pagado() {
		return valor_pagado;
	}
	public void setValor_pagado(int valor_pagado) {
		this.valor_pagado = valor_pagado;
	}
	public int getId_arrendatario() {
		return id_arrendatario;
	}
	public void setId_arrendatario(int id_arrendatario) {
		this.id_arrendatario = id_arrendatario;
	}
	public String getCodigo_inmueble() {
		return codigo_inmueble;
	}
	public void setCodigo_inmueble(String codigo_inmueble) {
		this.codigo_inmueble = codigo_inmueble;
	}
	public String getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	

}
