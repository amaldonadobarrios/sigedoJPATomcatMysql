package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.ArchivoDAO;
import entity.Archivo;
import entity.Usuario;
import util.DirTexto;

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
		System.out.println("obj.getObservaciones() : "+obj.getObservaciones());
		ar = em.getReference(Archivo.class, obj.getIdArchivo());
		ar.setEstado(1);
		ar.setId_fichero_archivo(obj.getId_fichero_archivo());
		ar.setUsuarioReg(obj.getUsuarioReg());
		ar.setPalabras_clave(DirTexto.getInstance().cambiarFormatoUTF8(obj.getPalabras_clave()));
		ar.setObservaciones(DirTexto.getInstance().cambiarFormatoUTF8(obj.getObservaciones()));
		ar.setFechaReg(obj.getFechaReg());
		em.merge(ar);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return ar.getIdArchivo();
	}

}
