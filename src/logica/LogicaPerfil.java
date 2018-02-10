package logica;

import entity.Perfil;
import service.PerfilService;
import service.impl.PerfilServiceImpl;

public class LogicaPerfil {
	// PATRON SINGLETON INI
		private static LogicaPerfil instance = null;

		public static synchronized LogicaPerfil getInstance() {
			if (instance == null) {
				instance = new LogicaPerfil();
			}
			return instance;
		}

		private LogicaPerfil() {
		}
		// PATRON SINGLETON FIN
		public Perfil  BuscarporId(int id) {
			PerfilService serv=new PerfilServiceImpl();
			Perfil  obj=null;
			obj=serv.BuscarxId(id);
			if (obj!=null) {
			return obj;	
			}
			return null;
		}
}
