package logica;

import entity.AlmacenArchivo;
import service.AlmacenArchivoService;
import service.impl.AlmacenArchivoServiceImpl;

public class LogicaAlmacenArchivo {
	// PATRON SINGLETON INI
	private static LogicaAlmacenArchivo instance = null;

	public static synchronized LogicaAlmacenArchivo getInstance() {
		if (instance == null) {
			instance = new LogicaAlmacenArchivo();
		}
		return instance;
	}

	private LogicaAlmacenArchivo() {
	}
	// PATRON SINGLETON FIN
	
	public int insertAlmacenArchivo(AlmacenArchivo obj) {
		int i=0;
		AlmacenArchivoService serv= new AlmacenArchivoServiceImpl();
		i=serv.save(obj);
		return i;
	}
}
