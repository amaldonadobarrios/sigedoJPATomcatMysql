package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DocumentoDAO;
import entity.Documento;
import entity.Usuario;

public class DocumentoDAOImpl implements DocumentoDAO {

	@Override
	public int GrabarDocumento(Documento doc) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(doc);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return doc.getIdDocumento();
	}

	@Override
	public Documento ModificarDocumento(Documento doc) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Documento u = null;
		u = em.getReference(Documento.class, doc.getIdDocumento());
		u.setIdEstadoDoc(doc.getIdEstadoDoc());
		u.setIdClasContenidoDoc(doc.getIdClasContenidoDoc());
		u.setIdFicheroDoc(doc.getIdFicheroDoc());
		u.setIdPrioridadDoc(doc.getIdPrioridadDoc());
		u.setIdTipoDoc(doc.getIdTipoDoc());
		u.setAsunto(doc.getAsunto());
		u.setFecha(doc.getFecha());
		u.setNumero(doc.getNumero());
		u.setSiglas(doc.getSiglas());
		u.setFechaReg(doc.getFechaReg());
		u.setIdUnidad(doc.getIdUnidad());
		u.setUsuReg(doc.getUsuReg());
		u.setIdUnidadReg(doc.getIdUnidadReg());
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u;
	}

	@Override
	public Documento CambiarEstadoDocumento(int id_estado, int id_doc) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Documento u = null;
		u = em.getReference(Documento.class, id_doc);
		u.setIdEstadoDoc(id_estado);
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u;
	}
}
