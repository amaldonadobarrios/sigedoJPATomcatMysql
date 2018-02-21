package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.ComboDocumentoDAO;
import entity.ClasContenidoDoc;
import entity.ClasFuncionDoc;
import entity.PrioridadDoc;
import entity.TipoDoc;

public class ComboDocumentoDAOImpl implements ComboDocumentoDAO {

	@Override
	public List<TipoDoc> ListaTipoDoc() {
		TipoDoc temp = null;
		List<TipoDoc> lista = null;
		String query = "SELECT id_tipo_doc, descripcion \r\n" + "FROM tipo_doc";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<TipoDoc>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new TipoDoc();
						temp.setIdTipoDoc(rs.getInt(1));
						temp.setDescripcion(rs.getString(2));
						lista.add(temp);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de ListaTipoDoc: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

	@Override
	public List<ClasContenidoDoc> ListaClasContenidoDoc() {
		ClasContenidoDoc temp = null;
		List<ClasContenidoDoc> lista = null;
		String query = "SELECT id_clas_contenido_doc, descripcion \r\n" + "FROM clas_contenido_doc\r\n" + "";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<ClasContenidoDoc>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new ClasContenidoDoc();
						temp.setIdClasContenidoDoc(rs.getInt(1));
						temp.setDescripcion(rs.getString(2));
						lista.add(temp);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de ListaTipoDoc: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

	@Override
	public List<ClasFuncionDoc> ListaClasFuncionDoc() {
		ClasFuncionDoc temp = null;
		List<ClasFuncionDoc> lista = null;
		String query = "SELECT id_clas_funcion_doc, descripcion \r\n" + "FROM clas_funcion_doc\r\n" + "";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<ClasFuncionDoc>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new ClasFuncionDoc();
						temp.setIdClasFuncionDoc(rs.getInt(1));
						temp.setDescripcion(rs.getString(2));
						lista.add(temp);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de ListaTipoDoc: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

	@Override
	public List<PrioridadDoc> ListaPrioridadDoc() {
		PrioridadDoc temp = null;
		List<PrioridadDoc> lista = null;
		String query = "SELECT id_prioridad_doc, descripcion \r\n" + 
				"FROM prioridad_doc;\r\n" + 
				"";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<PrioridadDoc>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new PrioridadDoc();
						temp.setIdPrioridadDoc(rs.getInt(1));
						temp.setDescripcion(rs.getString(2));
						lista.add(temp);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de ListaTipoDoc: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

}
