package dao.impl;

import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.FicheroDAO;
import entity.FicheroDoc;

public class FicheroDAOImpl implements FicheroDAO {

	@Override
	public int Grabar(FicheroDoc obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return obj.getIdFicheroDoc();
	}

	@Override
	public String RutaVerPDF(int id_fichero) {
		String codeB64 =null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		FicheroDoc u = null;
		u = em.getReference(FicheroDoc.class, id_fichero);
		em.getTransaction().commit();
		em.close();
		emf.close();
		Base64.Encoder code = Base64.getEncoder();
		codeB64 = code.encodeToString(u.getBlob());
		return codeB64+"||"+u.getTipo();
	}

	@Override
	public FicheroDoc Download(int id_fichero) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		FicheroDoc u = null;
		u = em.getReference(FicheroDoc.class, id_fichero);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u;
	}
}
