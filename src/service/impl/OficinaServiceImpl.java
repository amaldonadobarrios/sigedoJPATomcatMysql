package service.impl;

import java.util.List;

import dao.OficinaDAO;
import dao.impl.OficinaDAOImpl;
import entity.Oficina;
import service.OficinaService;

public class OficinaServiceImpl implements OficinaService {
OficinaDAO dao=new OficinaDAOImpl();
	@Override
	public int save(Oficina obj) {
		// TODO Auto-generated method stub
		return dao.save(obj);
	}

	@Override
	public Oficina Buscarxid(int id) {
		// TODO Auto-generated method stub
		return dao.Buscarxid(id);
	}

	@Override
	public List<Oficina> Listar() {
		// TODO Auto-generated method stub
		return dao.Listar();
	}

	@Override
	public List<Oficina> ListarxIdUnidad(int id_unidad) {
		// TODO Auto-generated method stub
		return dao.ListarxIdUnidad(id_unidad);
	}

}
