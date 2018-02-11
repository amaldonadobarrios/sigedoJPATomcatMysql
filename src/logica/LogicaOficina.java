package logica;
import java.util.ArrayList;
import java.util.List;

import entity.Oficina;
import service.OficinaService;
import service.impl.OficinaServiceImpl;

public class LogicaOficina {
	// PATRON SINGLETON INI
	private static LogicaOficina instance = null;

	public static synchronized LogicaOficina getInstance() {
		if (instance == null) {
			instance = new LogicaOficina();
		}
		return instance;
	}

	private LogicaOficina() {
	}
	// PATRON SINGLETON FIN
	public Oficina  BuscarporId(int id) {
		OficinaService serv=new OficinaServiceImpl();
		Oficina  obj=null;
		obj=serv.Buscarxid(id);
		if (obj!=null) {
		return obj;	
		}
		return null;
	}
	public List<Oficina>  BuscarporIdUnidad(int id_unidad) {
		OficinaService serv=new OficinaServiceImpl();
		List<Oficina>  obj= new ArrayList<Oficina>();
		obj= serv.ListarxIdUnidad(id_unidad);
		if (obj!=null) {
		return obj;	
		}
		return null;
	}
}
