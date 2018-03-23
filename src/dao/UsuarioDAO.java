package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entity.Usuario;
import entity.lista.Administrativo;

public interface UsuarioDAO {

	public Usuario validar(String usu,String pas) throws SQLException;
	public Usuario validar(int idusu,String pas) throws SQLException;
	public String img(String cip) throws IOException;
	public Usuario GrabarUsuario(Usuario usu);
	public Usuario ModificarUsuario(Usuario usu);
	public Usuario ModificarClave(Usuario usu);
	public Usuario BuscarxIdPersona(int id_persona);
	public List<Administrativo> ListarAdministrativoActivos(int unidad,int oficina);
}
