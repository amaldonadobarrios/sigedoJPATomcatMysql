package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.OficinaDAO;
import dao.config.PersistenceManager;
import entity.CentroTrabajo;
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

	@Override
	public Oficina Buscarxid(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    Oficina of=null;
	    of=em.getReference(Oficina.class, id);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
		return of;
	}

	@Override
	public List<Oficina> Listar() {
		Oficina temp = null;
		List <Oficina> lista=null;
		String query = "SELECT id_Oficina, descripcion FROM Oficina";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Oficina>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Oficina();
						temp.setIdOficina(rs.getInt(1));
						temp.setDescripcion(rs.getString(2));
						lista.add(temp);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de unidad: " + e.toString());
			} finally {
			    em.getTransaction().commit();
			    em.close();
			    emf.close();
			}
		}
		return lista;
	}

	@Override
	public List<Oficina> ListarxIdUnidad(int id_unidad) {
		Oficina temp = null;
		List <Oficina> lista=null;
		String query = "Select oficina.id_oficina, oficina.descripcion from  centro_trabajo\r\n" + 
				"INNER JOIN oficina ON oficina.id_oficina=centro_trabajo.id_oficina\r\n" + 
				"where centro_trabajo.id_unidad=? and centro_trabajo.estado=1";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id_unidad);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Oficina>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Oficina();
						temp.setIdOficina(rs.getInt(1));
						temp.setDescripcion(rs.getString(2));
						lista.add(temp);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de unidad: " + e.toString());
			} finally {
			    em.getTransaction().commit();
			    em.close();
			    emf.close();
			}
		}
		return lista;
	}

}
