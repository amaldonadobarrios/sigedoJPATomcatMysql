package logica;

import java.util.List;

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
				public List<Pretest> listarindicador1(){
					List<Pretest> lista=null;
					EstadisticaService serv=new EstadisticaServiceImpl();
					lista=serv.listarIndicador1();
					return lista;
				}
				public List<Pretest> listarindicador2(){
					List<Pretest> lista=null;
					EstadisticaService serv=new EstadisticaServiceImpl();
					lista=serv.listarIndicador2();
					return lista;
				}
}
