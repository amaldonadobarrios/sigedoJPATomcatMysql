package dao;

import java.util.List;

import entity.CentroTrabajo;

public interface CentroTrabajoDAO {
	public CentroTrabajo BuscarxId(int id);
	public List<CentroTrabajo> Listar();
	public List<CentroTrabajo> ListarxidUnixidOfi(int id_unidad, int id_oficina);
	public CentroTrabajo AsignarOficina(CentroTrabajo ct);
}
