package dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.io.IOUtils;

import dao.UsuarioDAO;
import entity.Unidad;
import entity.Usuario;
import entity.lista.Administrativo;
import util.BatEncriptador;
import util.ConstantSIGEDO;

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

	@Override
	public String img(String cip) throws IOException {
		int tamaño_cip = cip.length();
		String sSubCadena = cip.substring(tamaño_cip - 1, tamaño_cip);
		String rutaimagen = BatEncriptador.getInstance().Desencripta(ConstantSIGEDO.codigo) + sSubCadena + "/" + cip
				+ ".jpg";
		String encod = null;
		byte[] bytes;
		try {
			URL url = new URL(rutaimagen);
			URLConnection urlCon = url.openConnection();
			System.out.println(urlCon.getContentType());
			InputStream is = urlCon.getInputStream();
			bytes = IOUtils.toByteArray(is);
			Base64.Encoder code = Base64.getEncoder();
			encod = code.encodeToString(bytes);
		} catch (Exception e) {
			URL fileLocation = this.getClass().getResource("policia.jpg");
			bytes = IOUtils.toByteArray(fileLocation);
			Base64.Encoder code = Base64.getEncoder();
			encod = code.encodeToString(bytes);
		}
		return encod;
	}

	@Override
	public Usuario GrabarUsuario(Usuario usu) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return usu;
	}

	@Override
	public Usuario ModificarUsuario(Usuario usu) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Usuario u = null;
		u = em.getReference(Usuario.class, usu.getIdUsuario());
		u.setEstado(usu.getEstado());
		u.setFechaMod(usu.getFechaMod());
		u.setIdUsuarioMod(usu.getIdUsuarioMod());
		u.setUsuario(usu.getUsuario());
		u.setIdPerfil(usu.getIdPerfil());
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u;
	}

	public Usuario ModificarClave(Usuario usu) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Usuario u = null;
		u = em.getReference(Usuario.class, usu.getIdUsuario());
		u.setPassword(usu.getPassword());
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u;
	}

	@Override
	public Usuario BuscarxIdPersona(int id_persona) {
		Usuario usuario = null;
		String query = "SELECT id_usuario, usuario,estado, id_persona, id_perfil \r\n" + 
				"FROM usuario where id_persona=?;";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id_persona);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					usuario = new Usuario();
					usuario.setIdUsuario(rs.getInt(1));
					usuario.setUsuario(rs.getString(2));
					usuario.setEstado(rs.getInt(3));
					usuario.setIdPersona(rs.getInt(4));
					usuario.setIdPerfil(rs.getInt(5));
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

	@Override
	public List<Administrativo> ListarAdministrativoActivos(int unidad,int oficina) {
		Administrativo usuario = null;
		List<Administrativo> lista=null;
		String query = "select usu.id_usuario, concat(per.grado,' ',per.ape_pat,' ',per.ape_mat, ' ',per.nombres) as detalle from usuario usu\r\n" + 
				"inner join persona per on per.id_persona=usu.id_persona\r\n" + 
				"join centro_trabajo ct on ct.id_centro_trabajo=per.id_centro_trabajo\r\n" + 
				"join unidad uni on uni.id_unidad = ct.id_unidad\r\n" + 
				"join oficina ofi on ofi.id_oficina = ct.id_oficina\r\n" + 
				"join perfil perf on perf.id_perfil=usu.id_perfil\r\n" + 
				"where uni.id_unidad =? and ofi.id_oficina=? and usu.id_perfil=3 and usu.estado =1 ";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, unidad);
				ps.setInt(2, oficina);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Administrativo>();
					rs.beforeFirst();
					while (rs.next()) {
						usuario = new Administrativo();
						usuario.setId_usuario(rs.getInt(1));
						usuario.setDetalle(rs.getString(2));
						lista.add(usuario);
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
