package service.impl;

import dao.PersonaDAO;
import dao.impl.PersonaDAOImpl;
import entity.Persona;
import service.PersonaService;

public class PersonaServiceImpl implements PersonaService {
PersonaDAO dao=new PersonaDAOImpl();
	@Override
	public Persona BuscarxId(int id) {
		// TODO Auto-generated method stub
		return dao.BuscarxId(id);
	}
	@Override
	public Persona GrabarPersona(Persona obj) {
		// TODO Auto-generated method stub
		return dao.GrabarPersona(obj);
	}
	@Override
	public Persona BuscarxCip(String cip) {
		// TODO Auto-generated method stub
		return dao.BuscarxCip(cip);
	}
	@Override
	public Persona ModificarPersona(Persona obj) {
		// TODO Auto-generated method stub
		return dao.ModificarPersona(obj);
	}


}
