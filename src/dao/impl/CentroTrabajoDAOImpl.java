package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.CentroTrabajoDAO;
import entity.CentroTrabajo;

public class CentroTrabajoDAOImpl implements CentroTrabajoDAO {

	@Override
	public CentroTrabajo BuscarxId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CentroTrabajo obj = null;
		obj = em.getReference(CentroTrabajo.class, id);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return obj;
	}

	@Override
	public List<CentroTrabajo> Listar() {
		CentroTrabajo temp = null;
		List<CentroTrabajo> lista = null;
		String query = "SELECT id_centro_trabajo, id_unidad,id_oficina FROM centro_trabajo where estado=1";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<CentroTrabajo>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new CentroTrabajo();
						temp.setIdCentroTrabajo(rs.getInt(1));
						temp.setIdUnidad(rs.getInt(2));
						temp.setIdOficina(rs.getInt(3));
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
	public List<CentroTrabajo> ListarxidUnixidOfi(int id_unidad, int id_oficina) {
		CentroTrabajo temp = null;
		List<CentroTrabajo> lista = null;
		String query = "SELECT id_centro_trabajo, id_unidad,id_oficina FROM centro_trabajo where id_unidad=? and id_oficina=? and estado=1";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id_unidad);
				ps.setInt(2, id_oficina);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<CentroTrabajo>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new CentroTrabajo();
						temp.setIdCentroTrabajo(rs.getInt(1));
						temp.setIdUnidad(rs.getInt(2));
						temp.setIdOficina(rs.getInt(3));
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
	public CentroTrabajo AsignarOficina(CentroTrabajo ct) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ct);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return ct;
	}
}
