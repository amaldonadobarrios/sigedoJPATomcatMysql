package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PersonaDAO;
import entity.Persona;

public class PersonaDAOImpl implements PersonaDAO {

	@Override
	public Persona BuscarxId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Persona obj = null;
		obj = em.getReference(Persona.class, id);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return obj;
	}

	@Override
	public Persona GrabarPersona(Persona obj) {
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
	public Persona BuscarxCip(String cip) {
		Persona per = null;
		String query = "SELECT id_persona, cip, ape_pat, ape_mat, nombres, grado, dni, celular, id_centro_trabajo, estado \r\n"
				+ "FROM persona where cip=? limit 1";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, cip);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					per = new Persona();
					per.setApeMat(rs.getString("ape_mat"));
					per.setApePat(rs.getString("ape_pat"));
					per.setCelular(rs.getString("celular"));
					per.setCip(rs.getString("cip"));
					per.setDni(rs.getString("dni"));
					per.setEstado(rs.getInt("estado"));
					per.setGrado(rs.getString("grado"));
					per.setIdCentroTrabajo(rs.getInt("id_centro_trabajo"));
					per.setIdPersona(rs.getInt("id_persona"));
					per.setNombres(rs.getString("nombres"));
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de unidad: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return per;
	}

	@Override
	public Persona ModificarPersona(Persona obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Persona u = null;
		u = em.getReference(Persona.class, obj.getIdPersona());
		u.setApeMat(obj.getApeMat());
		u.setApePat(obj.getApePat());
		u.setCelular(obj.getCelular());
		u.setDni(obj.getDni());
		u.setEstado(obj.getEstado());
		u.setFechaMod(obj.getFechaMod());
		u.setGrado(obj.getGrado());
		u.setIdCentroTrabajo(obj.getIdCentroTrabajo());
		u.setNombres(obj.getNombres());
		u.setUsuMod(obj.getUsuMod());
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u;
	}

	@Override
	public Persona BuscarxCipSinPrivilegios(String cip) {
		Persona per = null;
		String query = "SELECT persona.id_persona, persona.cip, persona.ape_pat, persona.ape_mat, persona.nombres, persona.grado, persona.dni, persona.celular, id_centro_trabajo, persona.estado FROM persona\r\n"
				+ "INNER JOIN usuario ON persona.id_persona=usuario.id_persona\r\n"
				+ "where persona.cip=? and usuario.id_perfil!=6 and usuario.id_perfil!=1 limit 1";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, cip);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					per = new Persona();
					per.setApeMat(rs.getString("ape_mat"));
					per.setApePat(rs.getString("ape_pat"));
					per.setCelular(rs.getString("celular"));
					per.setCip(rs.getString("cip"));
					per.setDni(rs.getString("dni"));
					per.setEstado(rs.getInt("estado"));
					per.setGrado(rs.getString("grado"));
					per.setIdCentroTrabajo(rs.getInt("id_centro_trabajo"));
					per.setIdPersona(rs.getInt("id_persona"));
					per.setNombres(rs.getString("nombres"));
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de unidad: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return per;
	}

}
