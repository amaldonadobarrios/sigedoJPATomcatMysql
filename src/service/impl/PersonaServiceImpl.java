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


}
