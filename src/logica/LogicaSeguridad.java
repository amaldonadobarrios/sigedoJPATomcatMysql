package logica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.CentroTrabajo;
import entity.Oficina;
import entity.Perfil;
import entity.Persona;
import entity.Unidad;
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

	public boolean Validacion(String usu, String pas,HttpServletRequest request) throws SQLException {
		UsuarioService serv = new UsuarioServiceImpl();
		Usuario usuario = serv.validar(usu, pas);
		if (usuario != null) {
			if (usuario.getIdUsuario() > 0) {
				Persona per=LogicaPersona.getInstance().BuscarporId(usuario.getIdPersona());
				CentroTrabajo ct= LogicaCentroTrabajo.getInstance().BuscarporId(per.getIdCentroTrabajo());
				Unidad un=LogicaUnidad.getInstance().BuscarporId(ct.getIdUnidad());
				Oficina of=LogicaOficina.getInstance().BuscarporId(ct.getIdOficina());
				Perfil perf=LogicaPerfil.getInstance().BuscarporId(usuario.getIdPerfil());
				String foto = null;
				try {
					foto = LogicaUsuario.getInstance().getfoto(per.getCip());
				} catch (IOException e) {
					e.printStackTrace();
				}
				ArrayList<Object> SesionUsuario = new ArrayList<Object>();
				SesionUsuario.add(usuario);
				SesionUsuario.add(per);
				SesionUsuario.add(ct);
				SesionUsuario.add(un);
				SesionUsuario.add(of);
				SesionUsuario.add(perf);
				HttpSession sesion= request.getSession();
				sesion.setAttribute("usuario", SesionUsuario);
				sesion.setAttribute("img64", foto);
				sesion.setAttribute("ID", sesion.getId());
				sesion.setAttribute("CIP", per.getCip());
				sesion.setMaxInactiveInterval(300);
				return true;
			}
		}
		return false;
	}

}
