package logica;

import java.util.List;

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

	public CentroTrabajo BuscarporId(int id) {
		CentroTrabajoService serv = new CentroTrabajoServiceImpl();
		CentroTrabajo obj = null;
		obj = serv.BuscarxId(id);
		if (obj != null) {
			return obj;
		}
		return null;
	}

	public boolean ExisteCentroTrabajo(int id_unidad, int id_oficina) {
		CentroTrabajoService serv = new CentroTrabajoServiceImpl();
		List<CentroTrabajo> un = null;
		un = serv.ListarxidUnixidOfi(id_unidad, id_oficina);
		if (un != null) {
			return true;
		}
		return false;
	}

	public boolean AgregarCentroTrabajo(CentroTrabajo obj) {
		CentroTrabajoService serv = new CentroTrabajoServiceImpl();
		CentroTrabajo uni = null;
		uni = serv.AsignarOficina(obj);
		if (uni != null) {
			if (uni.getIdUnidad() > 0) {
				return true;
			}
		}
		return false;
	}
}
