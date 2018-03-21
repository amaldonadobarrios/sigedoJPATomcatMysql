package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dao.GraficoDAO;

public class GraficoDAOImpl implements GraficoDAO {

	@Override
	public String totArchivosAnio(int id_unidad) {
		JsonArray jason = null;
		String query = "select DATE_FORMAT(fecha_reg,'%Y') AS año, count(id_archivo) from archivo where id_unidad=?  GROUP BY YEAR(fecha_reg) asc";
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
					jason = new JsonArray();
					rs.beforeFirst();
					while (rs.next()) {
						JsonObject object = new JsonObject();
						object.addProperty("elemento", rs.getString(1));
						object.addProperty("cantidad", rs.getString(2));
						jason.add(object);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query totArchivosAnio: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return jason.toString();
	}

	@Override
	public String totArchivosMesAnioActual(int id_unidad) {
		JsonArray jason = null;
		String query = "select DATE_FORMAT(fecha_reg,'%b') AS mes, count(id_archivo) from archivo where DATE_FORMAT(fecha_reg,'%Y')=DATE_FORMAT(sysdate(),'%Y') and id_unidad=?  GROUP BY MONTH(fecha_reg) asc";
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
					jason = new JsonArray();
					rs.beforeFirst();
					while (rs.next()) {
						JsonObject object = new JsonObject();
						object.addProperty("elemento", rs.getString(1));
						object.addProperty("cantidad", rs.getString(2));
						jason.add(object);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query totArchivosAnio: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return jason.toString();
	}

	@Override
	public String TopAdministrativoMasRanking(int id_unidad) {
		JsonArray jason = null;
		String query = "select concat(per.grado,\" \", per.ape_pat,\" \", per.ape_mat,\" \", per.nombres) as usuario,\r\n" + 
				"count(mov.id_usuario_registro)as cant\r\n" + 
				"from movimiento_ht mov\r\n" + 
				"inner join usuario usu on usu.id_usuario=mov.id_usuario_registro\r\n" + 
				"join persona per on per.id_persona=usu.id_persona\r\n" + 
				"where id_estado_movimiento_ht='4' and id_unidad_registro=? group by 1 ";
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
					jason = new JsonArray();
					rs.beforeFirst();
					while (rs.next()) {
						JsonObject object = new JsonObject();
						object.addProperty("elemento", rs.getString(1));
						object.addProperty("cantidad", rs.getString(2));
						jason.add(object);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query totArchivosAnio: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return jason.toString();
	}

	@Override
	public String TopUsuarioSistema(int id_unidad) {
		JsonArray jason = null;
		String query = "select concat(per.grado,\" \", per.ape_pat,\" \", per.ape_mat,\" \", per.nombres) as usuario,\r\n" + 
				"count(mov.id_usuario_registro)as cant\r\n" + 
				"from movimiento_ht mov\r\n" + 
				"inner join usuario usu on usu.id_usuario=mov.id_usuario_registro\r\n" + 
				"join persona per on per.id_persona=usu.id_persona\r\n" + 
				"where  mov.id_unidad_registro=? group by 1 ";
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
					jason = new JsonArray();
					rs.beforeFirst();
					while (rs.next()) {
						JsonObject object = new JsonObject();
						object.addProperty("elemento", rs.getString(1));
						object.addProperty("cantidad", rs.getString(2));
						jason.add(object);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query totArchivosAnio: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return jason.toString();
	}

}
