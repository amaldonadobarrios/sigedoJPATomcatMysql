package service;

import java.io.IOException;
import java.sql.SQLException;

import entity.Usuario;

public interface UsuarioService {
	public Usuario validar(String usu,String pas) throws SQLException;
	public String img(String cip) throws IOException;
}
