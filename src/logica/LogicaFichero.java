package logica;

import entity.FicheroDoc;
import service.FicheroService;
import service.impl.FicheroServiceImpl;

public class LogicaFichero {
	// PATRON SINGLETON INI
	private static LogicaFichero instance = null;

	public static synchronized LogicaFichero getInstance() {
		if (instance == null) {
			instance = new LogicaFichero();
		}
		return instance;
	}

	private LogicaFichero() {
	}

	// PATRON SINGLETON FIN
	public int GrabarFichero(FicheroDoc obj) {
		FicheroService ser=new FicheroServiceImpl();
		int i=ser.Grabar(obj);
		if (i>0) {
			return i;
		}		
		return 0;
	}
	public String RutaVerPDF(int id_fichero) {
		FicheroService ser=new FicheroServiceImpl();
		return ser.RutaVerPDF(id_fichero);
	}
}
