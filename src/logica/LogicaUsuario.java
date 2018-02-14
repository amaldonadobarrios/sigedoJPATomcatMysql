package logica;

import java.io.IOException;

import entity.Usuario;
import service.UsuarioService;
import service.impl.UsuarioServiceImpl;

public class LogicaUsuario {
	// PATRON SINGLETON INI
	private static LogicaUsuario instance = null;

	public static synchronized LogicaUsuario getInstance() {
		if (instance == null) {
			instance = new LogicaUsuario();
		}
		return instance;
	}

	private LogicaUsuario() {
	}

	// PATRON SINGLETON FIN
	public String getfoto(String cip) throws IOException {
		String imgb64 = null;
		UsuarioService serv = new UsuarioServiceImpl();
		imgb64 = serv.img(cip);
		return imgb64;
	}

	public boolean grabarUsuario(Usuario usu) {
		UsuarioService serv = new UsuarioServiceImpl();
		Usuario usuario = null;
		usuario = serv.GrabarUsuario(usu);
		if (usuario != null) {
			return true;
		}
		return false;
	}
	public boolean ModificarUsuario(Usuario usu) {
		UsuarioService serv = new UsuarioServiceImpl();
		Usuario usuario = null;
		usuario = serv.ModificarUsuario(usu);
		if (usuario.getFechaMod().equals(usu.getFechaMod())) {
			return true;
		}
		return false;
	}
	public boolean ModificarClave(Usuario usu) {
		UsuarioService serv = new UsuarioServiceImpl();
		Usuario usuario = null;
		usuario = serv.ModificarClave(usu);
		if (usuario.getPassword().equals(usu.getPassword())) {
			return true;
		}
		return false;
	}
	public Usuario BuscarUsuarioxIdPersona(int id_persona) {
		UsuarioService serv = new UsuarioServiceImpl();
		Usuario usuario = null;
		usuario = serv.BuscarxIdPersona(id_persona);
		if (usuario!=null) {
			return usuario;
		}
		return null;
	}
}
