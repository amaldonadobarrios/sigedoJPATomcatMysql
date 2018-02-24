package logica;

import entity.MovimientoHt;
import service.MovimientoHTService;
import service.impl.MovimientoHTServiceImpl;

public class LogicaMovimientoHT {
	// PATRON SINGLETON INI
		private static LogicaMovimientoHT instance = null;

		public static synchronized LogicaMovimientoHT getInstance() {
			if (instance == null) {
				instance = new LogicaMovimientoHT();
			}
			return instance;
		}

		private LogicaMovimientoHT() {
		}

		// PATRON SINGLETON FIN
		public int grabarMovimientoHT(MovimientoHt ht) {
			MovimientoHTService serv = new MovimientoHTServiceImpl();
			return serv.GrabarMovimientoHT(ht);
		}
}
