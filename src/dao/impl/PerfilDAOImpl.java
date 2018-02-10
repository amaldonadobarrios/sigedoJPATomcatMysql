package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PerfilDAO;
import entity.CentroTrabajo;
import entity.Perfil;
import entity.Unidad;
import entity.Usuario;

public class PerfilDAOImpl implements PerfilDAO {

	@Override
	public Perfil BuscarxId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Perfil obj=null;
		    obj=em.getReference(Perfil.class, id);
		    em.getTransaction().commit();
		    em.close();
		    emf.close();
			return obj;
	}
	public List<Perfil> Listar() {
		Perfil temp = null;
		List <Perfil> lista=null;
		String query = "SELECT id_perfil, descripcion FROM Perfil";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Perfil>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Perfil();
						temp.setIdPerfil(rs.getInt(1));
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
