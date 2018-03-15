package logica;

import entity.HojaTramite;
import service.HojaTramiteService;
import service.impl.HojaTramiteServiceImpl;

public class LogicaHojaTramite {
	// PATRON SINGLETON INI
	private static LogicaHojaTramite instance = null;

	public static synchronized LogicaHojaTramite getInstance() {
		if (instance == null) {
			instance = new LogicaHojaTramite();
		}
		return instance;
	}

	private LogicaHojaTramite() {
	}

	// PATRON SINGLETON FIN
	public int grabarHT(HojaTramite ht) {
		HojaTramiteService serv = new HojaTramiteServiceImpl();
		return serv.GrabarHT(ht);
	}
	public int ArchivarEstadoHT(int id_ht) {
		HojaTramiteService serv = new HojaTramiteServiceImpl();
		return serv.ArchivarEstadoHT(id_ht);
	}
}
