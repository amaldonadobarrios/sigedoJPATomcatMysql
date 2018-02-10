package logica;

import entity.CentroTrabajo;
import service.CentroTrabajoService;
import service.impl.CentroTrabajoServiceImpl;

public class LogicaCentroTrabajo {
	// PATRON SINGLETON INI
	private static LogicaCentroTrabajo instance = null;

	public static synchronized LogicaCentroTrabajo getInstance() {
		if (instance == null) {
			instance = new LogicaCentroTrabajo();
		}
		return instance;
	}

	private LogicaCentroTrabajo() {
	}
	// PATRON SINGLETON FIN
	
	public CentroTrabajo  BuscarporId(int id) {
		CentroTrabajoService serv=new CentroTrabajoServiceImpl();
		CentroTrabajo  obj=null;
		obj=serv.BuscarxId(id);
		if (obj!=null) {
		return obj;	
		}
		return null;
	}
}
