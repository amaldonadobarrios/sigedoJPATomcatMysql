package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PersonaDAO;
import entity.Persona;

public class PersonaDAOImpl implements PersonaDAO {

	@Override
	public Persona BuscarxId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    Persona obj=null;
	    obj=em.getReference(Persona.class, id);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
		return obj;
	}

}
