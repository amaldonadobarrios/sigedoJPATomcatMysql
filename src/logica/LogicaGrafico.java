package logica;

import service.GraficoService;
import service.impl.GraficoServiceImpl;

public class LogicaGrafico {
	// PATRON SINGLETON INI
	private static LogicaGrafico instance = null;

	public static synchronized LogicaGrafico getInstance() {
		if (instance == null) {
			instance = new LogicaGrafico();
		}
		return instance;
	}

	private LogicaGrafico() {
	}

	// PATRON SINGLETON FIN
	
	public String GenerarGraficos(int id_unidad) {
		GraficoService serv=new GraficoServiceImpl();
		
		String graf1=serv.TopAdministrativoMasRanking(id_unidad);
		String graf2=serv.TopUsuarioSistema(id_unidad);
		String graf3=serv.totArchivosAnio(id_unidad);
		String graf4=serv.totArchivosMesAnioActual(id_unidad);
		
		return graf1+"||"+graf2+"||"+graf3+"||"+graf4;
	}
}
