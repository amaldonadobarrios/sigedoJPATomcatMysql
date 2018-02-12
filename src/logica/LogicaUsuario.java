package logica;

import java.io.IOException;

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
		String imgb64=null;
		UsuarioService serv=new UsuarioServiceImpl();
		imgb64=serv.img(cip);
		return imgb64;
	}
}
