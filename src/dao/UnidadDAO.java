package dao;

import java.util.List;

import entity.Unidad;

public interface UnidadDAO {
	public Unidad BuscarxId(int id);
	public List<Unidad> Listar();
}
