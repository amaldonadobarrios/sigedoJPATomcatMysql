package logica;
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
}
