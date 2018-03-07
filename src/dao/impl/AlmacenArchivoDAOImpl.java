package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.AlmacenArchivoDAO;
import entity.AlmacenArchivo;

public class AlmacenArchivoDAOImpl implements AlmacenArchivoDAO {

	@Override
	public int save(AlmacenArchivo obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(obj);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
		return obj.getIdAlmacenDocumento();
	}

}
