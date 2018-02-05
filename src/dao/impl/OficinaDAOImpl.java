package dao.impl;

import javax.persistence.EntityManager;

import dao.OficinaDAO;
import dao.config.PersistenceManager;
import entity.Oficina;

public class OficinaDAOImpl implements OficinaDAO {

	@Override
	public int save(Oficina obj) {
	    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	    em.getTransaction().begin();
	    em.persist(obj);
	    em.getTransaction().commit();
	    em.close();
	    PersistenceManager.INSTANCE.close();
		return obj.getIdOficina();
	}

}
