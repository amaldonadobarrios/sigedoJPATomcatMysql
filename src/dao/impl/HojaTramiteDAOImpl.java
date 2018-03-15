package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.HojaTramiteDAO;
import entity.Codeqr;
import entity.HojaTramite;
import entity.Usuario;

public class HojaTramiteDAOImpl implements HojaTramiteDAO {

	@Override
	public int GrabarHT(HojaTramite obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return obj.getIdHojaTramite();
	}

	@Override
	public int GrabarIdQR(Codeqr qr) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(qr);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return qr.getId_codigoQr();
	}

	@Override
	public String GrabarImagenQR(Codeqr qr) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Codeqr u = null;
		u = em.getReference(Codeqr.class, qr.getId_codigoQr());
		u.setCodeQr(qr.getCodeQr());
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return String.valueOf(u.getId_codigoQr());
	}

	@Override
	public int ArchivarEstadoHT(int id_HT) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		HojaTramite u = null;
		u = em.getReference(HojaTramite.class, id_HT);
		u.setIdEstadoHt(2);
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u.getIdHojaTramite();
	}

}
