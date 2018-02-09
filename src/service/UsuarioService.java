package service;

import java.sql.SQLException;

import entity.Usuario;

public interface UsuarioService {
	public Usuario validar(String usu,String pas) throws SQLException;
}
