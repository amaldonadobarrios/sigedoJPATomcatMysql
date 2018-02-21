package logica;

import java.util.List;

import entity.CentroTrabajo;
import entity.ClasContenidoDoc;
import entity.ClasFuncionDoc;
import entity.Oficina;
import entity.PrioridadDoc;
import entity.TipoDoc;
import entity.Unidad;
import service.CentroTrabajoService;
import service.ComboDocumentoService;
import service.OficinaService;
import service.UnidadService;
import service.impl.CentroTrabajoServiceImpl;
import service.impl.ComboDocumentoServiceImpl;
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
		public List<TipoDoc> ListaTipoDoc(){
			ComboDocumentoService serv=new ComboDocumentoServiceImpl();
			return serv.ListaTipoDoc();
		}
		public List<ClasContenidoDoc> ListaClasContenidoDoc(){
			ComboDocumentoService serv=new ComboDocumentoServiceImpl();	
			return serv.ListaClasContenidoDoc();
		}
		public List<ClasFuncionDoc> ListaClasFuncionDoc(){
			ComboDocumentoService serv=new ComboDocumentoServiceImpl();	
			return serv.ListaClasFuncionDoc();
		}
		public List<PrioridadDoc> ListaPrioridadDoc(){
			ComboDocumentoService serv=new ComboDocumentoServiceImpl();	
			return serv.ListaPrioridadDoc();
		}
		
		
}
