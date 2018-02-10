package service;

import java.util.List;

import entity.Unidad;

public interface UnidadService {
	public Unidad BuscarxId(int id);
	public List<Unidad> Listar();
}
