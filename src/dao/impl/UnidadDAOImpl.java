package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.UnidadDAO;
import entity.Unidad;

public class UnidadDAOImpl implements UnidadDAO {

	@Override
	public Unidad BuscarxId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    Unidad obj=null;
	    obj=em.getReference(Unidad.class, id);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
		return obj;
	}

	@Override
	public List<Unidad> Listar() {
		Unidad temp = null;
		List <Unidad> lista=null;
		String query = "SELECT id_unidad, descripcion FROM unidad";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Unidad>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Unidad();
						temp.setIdUnidad(rs.getInt(1));
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
	public Unidad AgregarUnidad(Unidad obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(obj);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	   return obj;
	}

	@Override
	public List<Unidad>  Buscarxdescripcion(String descripcion) {
		Unidad temp = null;
		List <Unidad> lista=null;
		String query = "SELECT id_unidad, descripcion FROM unidad where descripcion=? and estado=1";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, descripcion);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Unidad>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Unidad();
						temp.setIdUnidad(rs.getInt(1));
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
