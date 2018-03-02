package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.BandejaDAO;
import entity.CentroTrabajo;
import entity.lista.Bandeja;

public class BandejaDAOImpl implements BandejaDAO {

	@Override
	public List<Bandeja> listaBandeja(int id_estado_movimiento, int id_unidad_destino) {
		Bandeja temp = null;
		List<Bandeja> lista = null;
		String query = "SELECT  ma.maximo as id_movimiento "
				+ ",mov.id_hoja_tramite,"
				+ " mov.id_documento,"
				+ " mov.id_usuario_registro,"
				+ " mov.id_unidad_registro,"
				+ " mov.id_oficina_registro,"
				+ "ht.asunto,"
				+ "  emov.descripcion as estado_mov,"
				+ " mov.observaciones,"
				+ "doc.id_fichero_doc,"
				+ "doc.id_prioridad_doc,"
				+ " concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,"
				+ "doc.fecha_doc ,"
				+ " mov.fecha_registro,"
				+ " docini.id_fichero_doc as id_fichero_ini,"
				+ "ht.id_documento_inicio\r\n" + 
				"FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma\r\n" + 
				"inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht\r\n" + 
				"join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite\r\n" + 
				"join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht\r\n" + 
				"join documento doc on mov.id_documento=doc.id_documento\r\n" +
				"join documento docini on ht.id_documento_inicio=docini.id_documento\r\n" + 
				"join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc "
				+ "where mov.id_estado_movimiento_ht=? and mov.id_unidad_destino=?";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id_estado_movimiento);
				ps.setInt(2, id_unidad_destino);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Bandeja>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Bandeja();
						temp.setId_movimiento(rs.getInt(1));
						temp.setId_hoja_tramite(rs.getInt(2));
						temp.setId_documento(rs.getInt(3));
						temp.setId_usuario_registro(rs.getInt(4));
						temp.setId_unidad_registro(rs.getInt(5));
						temp.setId_oficina_registro(rs.getInt(6));
						temp.setAsunto(rs.getString(7));
						temp.setEstado_mov(rs.getString(8));
						temp.setObservaciones(rs.getString(9));
						temp.setId_fichero(rs.getInt(10));
						temp.setId_prioridad(rs.getInt(11));
						temp.setDocumento(rs.getString(12));
						temp.setFecha_doc(rs.getDate(13));
						temp.setFecha_reg(rs.getDate(14));
						temp.setId_fichero_ini(rs.getInt(15));
						temp.setId_documento_ini(rs.getInt(16));
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
