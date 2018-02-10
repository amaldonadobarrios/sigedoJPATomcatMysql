package dao;

import java.util.List;

import entity.CentroTrabajo;

public interface CentroTrabajoDAO {
	public CentroTrabajo BuscarxId(int id);
	public List<CentroTrabajo> Listar();
}
