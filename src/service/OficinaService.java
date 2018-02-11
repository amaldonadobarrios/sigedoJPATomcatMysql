package service;

import java.util.List;

import entity.Oficina;

public interface OficinaService {
	public int save(Oficina obj);
	public Oficina Buscarxid(int id);
	public List<Oficina> Listar();
	public List<Oficina> ListarxIdUnidad(int id_unidad);
}
