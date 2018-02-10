package service;

import java.util.List;

import entity.CentroTrabajo;

public interface CentroTrabajoService {
	public CentroTrabajo BuscarxId(int id);
	public List<CentroTrabajo> Listar();
}
