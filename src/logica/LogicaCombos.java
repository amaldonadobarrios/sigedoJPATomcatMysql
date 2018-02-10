package logica;

import java.util.List;

import entity.CentroTrabajo;
import entity.Oficina;
import entity.Unidad;
import service.CentroTrabajoService;
import service.OficinaService;
import service.UnidadService;
import service.impl.CentroTrabajoServiceImpl;
import service.impl.OficinaServiceImpl;
import service.impl.UnidadServiceImpl;

public class LogicaCombos {
	// PATRON SINGLETON INI
		private static LogicaCombos instance = null;

		public static synchronized LogicaCombos getInstance() {
			if (instance == null) {
				instance = new LogicaCombos();
			}
			return instance;
		}

		private LogicaCombos() {
		}
		// PATRON SINGLETON FIN
		public List<Unidad> ListaUnidad() {
			UnidadService serv= new UnidadServiceImpl();
			return serv.Listar();
		}

		public List<Oficina> ListaOficina(){
			OficinaService serv=new OficinaServiceImpl();
			return serv.Listar();
		}

		public List<CentroTrabajo> ListaCentroTrabajo() {
			CentroTrabajoService serv= new CentroTrabajoServiceImpl();
			return serv.Listar();
		}
		
		
}
