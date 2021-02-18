package com.sinfloo.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sinfloo.demo.modelo.Persona;

public interface IpersonaService {
	public List<Persona>listar();
	public Optional<Persona>listarId(int id_arrendatario);
	public int save(Persona p);
	public void delete(int id_arrendatario);
}
