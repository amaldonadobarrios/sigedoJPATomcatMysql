package logica;

import java.util.List;

import entity.Unidad;
import service.UnidadService;
import service.impl.UnidadServiceImpl;

public class LogicaUnidad {
	// PATRON SINGLETON INI
	private static LogicaUnidad instance = null;

	public static synchronized LogicaUnidad getInstance() {
		if (instance == null) {
			instance = new LogicaUnidad();
		}
		return instance;
	}

	private LogicaUnidad() {
	}
	// PATRON SINGLETON FIN

	public Unidad BuscarporId(int id) {
		UnidadService serv = new UnidadServiceImpl();
		Unidad obj = null;
		obj = serv.BuscarxId(id);
		if (obj != null) {
			return obj;
		}
		return null;
	}

	public List<Unidad> ListaUnidad() {
		UnidadService serv = new UnidadServiceImpl();
		return serv.Listar();
	}

	public boolean ExisteUnidad(String descripcion) {
		UnidadService serv = new UnidadServiceImpl();
		List<Unidad> un = null;
		un = serv.Buscarxdescripcion(descripcion);
		if (un != null) {
			return true;
		}
		return false;
	}

	public boolean AgregarUnidad(Unidad obj) {
		UnidadService serv = new UnidadServiceImpl();
		Unidad uni = null;
		uni = serv.AgregarUnidad(obj);
		if (uni != null) {
			if (uni.getIdUnidad() > 0) {
				return true;
			}
		}
		return false;
	}
}
