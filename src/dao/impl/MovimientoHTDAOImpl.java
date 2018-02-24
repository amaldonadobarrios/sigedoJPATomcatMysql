package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.MovimientoHTDAO;
import entity.MovimientoHt;

public class MovimientoHTDAOImpl implements MovimientoHTDAO {

	@Override
	public int GrabarMovimientoHT(MovimientoHt MHT) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(MHT);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return MHT.getIdMovimientoHt();
	}

}
