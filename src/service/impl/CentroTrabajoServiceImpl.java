package service.impl;

import java.util.List;

import dao.CentroTrabajoDAO;
import dao.impl.CentroTrabajoDAOImpl;
import entity.CentroTrabajo;
import service.CentroTrabajoService;

public class CentroTrabajoServiceImpl implements CentroTrabajoService {
	CentroTrabajoDAO dao=new CentroTrabajoDAOImpl();
	@Override
	public CentroTrabajo BuscarxId(int id) {
		// TODO Auto-generated method stub
		return dao.BuscarxId(id);
	}
	@Override
	public List<CentroTrabajo> Listar() {
		// TODO Auto-generated method stub
		return dao.Listar();
	}
	@Override
	public List<CentroTrabajo> ListarxidUnixidOfi(int id_unidad, int id_oficina) {
		// TODO Auto-generated method stub
		return dao.ListarxidUnixidOfi(id_unidad, id_oficina);
	}
	@Override
	public CentroTrabajo AsignarOficina(CentroTrabajo ct) {
		// TODO Auto-generated method stub
		return dao.AsignarOficina(ct);
	}

}
