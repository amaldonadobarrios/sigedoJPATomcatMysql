package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.FicheroDAO;
import entity.FicheroDoc;

public class FicheroDAOImpl implements FicheroDAO {

	@Override
	// public int Grabar(FicheroDoc obj) {
	// int resultado = 0;
	// String query = "CALL Grabar_Fichero(?,?,?,?,?,?);";
	// EntityManagerFactory emf =
	// Persistence.createEntityManagerFactory("PwSigedo");
	// EntityManager em = emf.createEntityManager();
	// java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
	//
	// try {
	// System.out.println("VOY A GRBAR");
	// CallableStatement ps = cn.prepareCall(query);
	// ps.setBytes(1, obj.getBlob());
	// ps.setInt(2, obj.getEstado());
	// ps.setString(3, obj.getNombre());
	// ps.setString(4, obj.getSize());
	// ps.setString(5, obj.getTipo());
	// ps.registerOutParameter(6, Types.INTEGER);
	// if (ps.execute()) {
	// resultado = ps.getInt(6);
	// System.out.println("RESULTADO ES :------------------" + resultado);
	// }
	// } catch (SQLException e) {
	// System.out.println("Excepcion en query obtenercodigo de unidad: " +
	// e.toString());
	// } finally {
	// em.close();
	// emf.close();
	// }
	//
	// return resultado;
	// }
	public int Grabar(FicheroDoc obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return obj.getIdFicheroDoc();
	}
}
