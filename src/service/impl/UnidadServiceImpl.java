package service.impl;

import java.util.List;

import dao.UnidadDAO;
import dao.impl.UnidadDAOImpl;
import entity.Unidad;
import service.UnidadService;

public class UnidadServiceImpl implements UnidadService {
UnidadDAO dao=new UnidadDAOImpl();
	@Override
	public Unidad BuscarxId(int id) {
		// TODO Auto-generated method stub
		return dao.BuscarxId(id);
	}
	@Override
	public List<Unidad> Listar() {
		// TODO Auto-generated method stub
		return dao.Listar();
	}

}
