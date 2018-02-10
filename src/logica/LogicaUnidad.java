package logica;

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
	
	public Unidad  BuscarporId(int id) {
		UnidadService serv=new UnidadServiceImpl();
		Unidad  obj=null;
		obj=serv.BuscarxId(id);
		if (obj!=null) {
		return obj;	
		}
		return null;
	}
}
