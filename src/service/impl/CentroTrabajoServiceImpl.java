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

}
