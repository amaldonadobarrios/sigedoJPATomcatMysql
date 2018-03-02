package logica;

import java.util.List;

import entity.lista.Bandeja;
import service.BandejaService;
import service.impl.BandejaServiceImpl;

public class LogicaBandeja {
	// PATRON SINGLETON INI
	private static LogicaBandeja instance = null;

	public static synchronized LogicaBandeja getInstance() {
		if (instance == null) {
			instance = new LogicaBandeja();
		}
		return instance;
	}

	private LogicaBandeja() {
	}
	// PATRON SINGLETON FIN

	public List<Bandeja> ListarBandeja(int estadoBandeja,int id_unidad_destino) {
		BandejaService serv = new BandejaServiceImpl();
		List<Bandeja> bandeja = null;
		bandeja = serv.listaBandeja(estadoBandeja,id_unidad_destino);
		return bandeja;
	}
}
