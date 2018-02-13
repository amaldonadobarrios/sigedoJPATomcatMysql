package service.impl;

import java.io.IOException;
import java.sql.SQLException;

import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;
import entity.Usuario;
import service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	UsuarioDAO dao = new UsuarioDAOImpl();

	@Override
	public Usuario validar(String usu, String pas) throws SQLException {
		return dao.validar(usu, pas);
	}

	@Override
	public String img(String cip) throws IOException {
		// TODO Auto-generated method stub
		return dao.img(cip);
	}

	@Override
	public Usuario GrabarUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		return dao.GrabarUsuario(usu);
	}

	@Override
	public Usuario ModificarUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		return dao.ModificarUsuario(usu);
	}

	@Override
	public Usuario ModificarClave(Usuario usu) {
		// TODO Auto-generated method stub
		return dao.ModificarClave(usu);
	}

}
