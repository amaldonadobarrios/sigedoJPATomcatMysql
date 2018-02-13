package logica;
import java.util.ArrayList;
import java.util.List;

import entity.Oficina;
import entity.Unidad;
import service.OficinaService;
import service.UnidadService;
import service.impl.OficinaServiceImpl;
import service.impl.UnidadServiceImpl;

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
		try {
			obj= serv.ListarxIdUnidad(id_unidad);	
		} catch (Exception e) {
			System.out.println("NO hay oficinas");
		}
		if (obj!=null) {
		return obj;	
		}
		return null;
	}
	public List<Oficina>  ListarOficina() {
		OficinaService serv=new OficinaServiceImpl();
		List<Oficina>  obj= new ArrayList<Oficina>();
		obj= serv.Listar();
		if (obj!=null) {
		return obj;	
		}
		return null;
	}
	public boolean ExisteOficina(String descripcion) {
		OficinaService serv = new OficinaServiceImpl();
		List<Oficina> un = null;
		un = serv.Buscarxdescripcion(descripcion);
		if (un != null) {
			return true;
		}
		return false;
	}
	public boolean AgregarOficina(Oficina obj) {
		OficinaService serv = new OficinaServiceImpl();
		int uni = 0;
		uni = serv.save(obj);
		if (uni >0) {
			return true;
			}
		return false;
	}
}
