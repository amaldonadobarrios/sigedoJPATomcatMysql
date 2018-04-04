package logica;

import java.util.List;

import entity.estadistica.EstDocumentoRecibido;
import entity.estadistica.Pretest;
import service.EstadisticaService;
import service.impl.EstadisticaServiceImpl;

public class LogicaEstadistica {
	// PATRON SINGLETON INI
				private static LogicaEstadistica instance = null;

				public static synchronized LogicaEstadistica getInstance() {
					if (instance == null) {
						instance = new LogicaEstadistica();
					}
					return instance;
				}

				private LogicaEstadistica() {
				}
				// PATRON SINGLETON FIN
				
				public List<Pretest> listarindicador2(){
					List<Pretest> lista=null;
					EstadisticaService serv=new EstadisticaServiceImpl();
					lista=serv.listarIndicador2();
					return lista;
				}
				public List<Pretest> listarindicador1ACTUALIZADO(){
					List<Pretest> lista=null;
					EstadisticaService serv=new EstadisticaServiceImpl();
					lista=serv.listarIndicador1ACTUALLIZADO();
					return lista;
				}
				public List<EstDocumentoRecibido> listarDocumentoRecibidoEst(int id_unidad, String fecha1, String fecha2){
					List<EstDocumentoRecibido> lista=null;
					EstadisticaService serv=new EstadisticaServiceImpl();
					lista=serv.listarDocRecibido(id_unidad, fecha1, fecha2);
					return lista;
				}
}
