package logica;

import entity.Archivo;
import service.ArchivoService;
import service.impl.ArchivoServiceImpl;

public class LogicaArchivo {
	// PATRON SINGLETON INI
	private static LogicaArchivo instance = null;

	public static synchronized LogicaArchivo getInstance() {
		if (instance == null) {
			instance = new LogicaArchivo();
		}
		return instance;
	}

	private LogicaArchivo() {
	}
	// PATRON SINGLETON FIN
	
	public int insertArchivo(Archivo obj) {
		int i=0;
		ArchivoService serv= new ArchivoServiceImpl();
		i=serv.save(obj);
		return i;
	}
	public int updateArchivo(Archivo obj) {
		int i=0;
		ArchivoService serv= new ArchivoServiceImpl();
		i=serv.Update(obj);
		return i;
	}
}
