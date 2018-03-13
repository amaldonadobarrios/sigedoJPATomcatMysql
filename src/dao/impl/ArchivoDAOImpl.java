package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.ArchivoDAO;
import entity.Archivo;
import entity.Usuario;

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

	@Override
	public int Update(Archivo obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Archivo ar = null;
		ar = em.getReference(Archivo.class, obj.getIdArchivo());
		ar.setEstado(1);
		ar.setId_fichero_archivo(obj.getId_fichero_archivo());
		ar.setUsuarioReg(obj.getUsuarioReg());
		ar.setPalabras_clave(obj.getPalabras_clave());
		ar.setObservaciones(obj.getObservaciones());
		ar.setFechaReg(obj.getFechaReg());
		em.merge(ar);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return ar.getIdArchivo();
	}

}
