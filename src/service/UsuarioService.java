package service;

import java.io.IOException;
import java.sql.SQLException;

import entity.Usuario;

public interface UsuarioService {
	public Usuario validar(String usu,String pas) throws SQLException;
	public String img(String cip) throws IOException;
	public Usuario GrabarUsuario(Usuario usu);
	public Usuario ModificarUsuario(Usuario usu);
	public Usuario ModificarClave(Usuario usu);
	public Usuario BuscarxIdPersona(int id_persona);
}
