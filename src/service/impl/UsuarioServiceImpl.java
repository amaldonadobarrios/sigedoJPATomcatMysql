package service.impl;

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

}
