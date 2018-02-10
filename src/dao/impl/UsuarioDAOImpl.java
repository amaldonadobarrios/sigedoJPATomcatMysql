package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.UsuarioDAO;
import dao.config.PersistenceManager;
import entity.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public Usuario validar(String usu, String pas) throws SQLException {
		Usuario usuario = null;
		String query = "SELECT id_usuario, estado, id_persona, id_perfil FROM   usuario  WHERE usuario =? and password=? and estado=1";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, usu);
				ps.setString(2, pas);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					usuario = new Usuario();
					usuario.setIdUsuario(rs.getInt(1));
					usuario.setEstado(rs.getInt(2));
					usuario.setIdPersona(rs.getInt(3));
					usuario.setIdPerfil(rs.getInt(4));
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de unidad: " + e.toString());
			} finally {
			    em.getTransaction().commit();
			    em.close();
			    emf.close();
			}
		}
		return usuario;

	}

}
