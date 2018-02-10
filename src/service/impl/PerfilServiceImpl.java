package service.impl;

import java.util.List;

import dao.PerfilDAO;
import dao.impl.PerfilDAOImpl;
import entity.Perfil;
import service.PerfilService;

public class PerfilServiceImpl implements PerfilService {
PerfilDAO dao=new PerfilDAOImpl();
	@Override
	public Perfil BuscarxId(int id) {
		// TODO Auto-generated method stub
		return dao.BuscarxId(id);
	}
	@Override
	public List<Perfil> Listar() {
		// TODO Auto-generated method stub
		return dao.Listar();
	}

}
