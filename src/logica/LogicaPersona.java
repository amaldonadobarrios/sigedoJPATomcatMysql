package logica;

import entity.Persona;
import service.PersonaService;
import service.impl.PersonaServiceImpl;

public class LogicaPersona {
	// PATRON SINGLETON INI
	private static LogicaPersona instance = null;

	public static synchronized LogicaPersona getInstance() {
		if (instance == null) {
			instance = new LogicaPersona();
		}
		return instance;
	}

	private LogicaPersona() {
	}
	// PATRON SINGLETON FIN

	public Persona BuscarporId(int id) {
		PersonaService serv = new PersonaServiceImpl();
		Persona per = null;
		per = serv.BuscarxId(id);
		if (per != null) {
			return per;
		}
		return null;
	}

	public int grabarPersona(Persona per) {
		PersonaService serv = new PersonaServiceImpl();
		Persona persona = null;
		persona = serv.GrabarPersona(per);
		if (persona != null) {
			return persona.getIdPersona();
		}
		return 0;
	}
	
	public Persona Buscarxcip(String cip) {
		PersonaService serv = new PersonaServiceImpl();
		Persona per = null;
		per = serv.BuscarxCip(cip);
		if (per != null) {
			return per;
		}
		return null;	
	}
	public Persona BuscarxCipSinPrivilegios(String cip) {
		PersonaService serv = new PersonaServiceImpl();
		Persona per = null;
		per = serv.BuscarxCipSinPrivilegios(cip);
		if (per != null) {
			return per;
		}
		return null;	
	}
	public boolean ExistePersona(String cip) {
		PersonaService serv = new PersonaServiceImpl();
		Persona per = null;
		per = serv.BuscarxCip(cip);
		if (per != null) {
			return true;
		}
		return false;	
	}
	public boolean Actualizar(Persona per) {
		PersonaService serv = new PersonaServiceImpl();
		Persona perso=null;
		perso=new Persona();
		perso=serv.ModificarPersona(per);
		if (perso.getFechaMod().equals(per.getFechaMod())) {
			return true;
		}
		return false;
	}
}
