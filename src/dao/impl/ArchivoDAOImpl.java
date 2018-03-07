package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.ArchivoDAO;
import entity.Archivo;

public class ArchivoDAOImpl implements ArchivoDAO {

	@Override
	public int save(Archivo obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(obj);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
		return obj.getIdArchivo();
	}

}
