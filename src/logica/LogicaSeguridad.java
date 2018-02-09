package logica;

import java.sql.SQLException;

import entity.Usuario;
import service.UsuarioService;
import service.impl.UsuarioServiceImpl;

public class LogicaSeguridad {
	// PATRON SINGLETON INI
	private static LogicaSeguridad instance = null;

	public static synchronized LogicaSeguridad getInstance() {
		if (instance == null) {
			instance = new LogicaSeguridad();
		}
		return instance;
	}

	private LogicaSeguridad() {
	}
	// PATRON SINGLETON FIN

	public boolean Validacion(String usu, String pas) throws SQLException {
		UsuarioService serv = new UsuarioServiceImpl();
		Usuario usuario = serv.validar(usu, pas);
		if (usuario != null) {
			if (usuario.getIdUsuario() > 0) {
				return true;
			}
		}
		return false;
	}

}
