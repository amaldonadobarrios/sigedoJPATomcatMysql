package dao;

import java.sql.SQLException;

import entity.Usuario;

public interface UsuarioDAO {

	public Usuario validar(String usu,String pas) throws SQLException;
	
}
