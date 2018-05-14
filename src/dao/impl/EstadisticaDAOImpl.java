package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EstadisticaDAO;
import entity.estadistica.EstDocumentoRecibido;
import entity.estadistica.PostTest;
import entity.estadistica.Pretest;

public class EstadisticaDAOImpl implements EstadisticaDAO {

	

	@Override
	public List<Pretest> listarIndicador2() {
		Pretest temp = null;
		List<Pretest> lista = null;
		PreparedStatement ps = null;
		String query = "SELECT id_pretest,\r\n" + 
				"				fecha_doc,\r\n" + 
				"				siglas, \r\n" + 
				"				asunto,\r\n" + 
				"				EVA1I2,\r\n" + 
				"				IF (EVA1I2<=15,'SI','NO') AS VAL1 FROM pretest";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Pretest>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Pretest();
						 temp.setNroindicador(String.valueOf(2));
						 temp.setIndicador("PORCENTAJE DE DOCUMENTO ACCEDIDOS DENTRO DEL PLAZO");
						 temp.setFechadoc(rs.getDate("fecha_doc"));
						 temp.setSiglas(rs.getString("siglas"));
						 temp.setAsunto(rs.getString("asunto"));
						 temp.setEva1(rs.getString("EVA1I2"));
						 temp.setEva2(rs.getString("VAL1"));
						lista.add(temp);
					}
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query Pretest de indicador 2: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

	@Override
	public List<Pretest> listarIndicador1ACTUALLIZADO() {
		Pretest temp = null;
		List<Pretest> lista = null;
		PreparedStatement ps = null;
		String query = "SELECT id_pretest, fecha_doc, siglas, asunto, IF (EVA1I1=1, 'APROPIADO','INAPROPIADO') AS EVA1I1\r\n" + 
				"FROM pretest ";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Pretest>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Pretest();
						 temp.setNroindicador(String.valueOf(1));
						 temp.setIndicador("PORCENTAJE DE DOCUMENTOS NO CLASIFICADOS APROPIADAMENTE");
						 temp.setFechadoc(rs.getDate("fecha_doc"));
						 temp.setSiglas(rs.getString("siglas"));
						 temp.setAsunto(rs.getString("asunto"));
						 temp.setEva1(rs.getString("EVA1I1")); 
						lista.add(temp);
					}
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query Pretest de indicador 1: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

	@Override
	public List<EstDocumentoRecibido> listarDocRecibido(int id_unidad, String fecha1, String fecha2) {
		EstDocumentoRecibido temp = null;
		List<EstDocumentoRecibido> lista = null;
		PreparedStatement ps = null;
		String query = "select recibido.id_hoja_tramite,"
				+ "recibido.id_documento,"
				+ "concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,"
				+ "doc.asunto,"
				+ " DATE_FORMAT(doc.fecha_doc, \"%Y-%m-%d\") as fechadoc  ,"
				+ "recibido.fecha_registro,"
				+ " eht.descripcion,"
				+ " estht.descripcion as estmaxht,"
				+ " movmax.fecha_registro as fecharegmax,"
				+ " movmax.observaciones from\r\n" + 
				"(SELECT id_movimiento_ht, id_unidad_destino, id_oficina_destino, id_usuario_destino, fecha_registro, id_usuario_registro, id_unidad_registro, id_oficina_registro, id_hoja_tramite, id_documento, id_estado_movimiento_ht, observaciones \r\n" + 
				"FROM movimiento_ht where id_estado_movimiento_ht='2' and fecha_registro BETWEEN ? AND ? and id_unidad_registro=? )  recibido\r\n" + 
				" inner join  hoja_tramite ht on ht.id_hoja_tramite=recibido.id_hoja_tramite\r\n" + 
				" join estado_ht eht on eht.id_estado_ht=ht.id_estado_ht \r\n" + 
				"join(select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest, mvht.id_hoja_tramite as maxidht, mvht.fecha_registro as maxfechareg from movimiento_ht mvht where id_unidad_registro=? group by mvht.id_hoja_tramite ) maximomovimiento on recibido.id_hoja_tramite=maximomovimiento.maxidht\r\n" + 
				"join movimiento_ht movmax on movmax.id_movimiento_ht=maximomovimiento.maximo\r\n" + 
				"join estado_movimiento_ht estht on estht.id_estado_movimiento_ht= movmax.id_estado_movimiento_ht\r\n" + 
				"join documento doc on doc.id_documento = recibido.id_documento\r\n" + 
				"join tipo_doc tdoc on tdoc.id_tipo_doc=doc.id_tipo_doc";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ps.setString(1, fecha1);
				ps.setString(2, fecha2);
				ps.setInt(3, id_unidad);
				ps.setInt(4, id_unidad);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<EstDocumentoRecibido>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new EstDocumentoRecibido();
						 temp.setAsunto(rs.getString("asunto"));
						 temp.setDocumento(rs.getString("documento"));
						 temp.setEstht(rs.getString("descripcion"));
						 temp.setEstmax(rs.getString("estmaxht"));
						 temp.setFechadoc(rs.getDate("fechadoc"));
						 temp.setFechareg(rs.getDate("fecha_registro"));
						 temp.setFecharegmax(rs.getDate("fecharegmax"));
						 temp.setId_documento(rs.getInt("id_documento"));
						 temp.setId_hoja_tramite(rs.getInt("id_hoja_tramite"));
						 temp.setObservaciones(rs.getString("observaciones"));
						lista.add(temp);
					}
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query listarDocRecibido: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

	@Override
	public List<PostTest> LocalizacionDocumentos(int id_unidad, String fecha1, String fecha2) {
		
		List<PostTest> lista = null;
		PostTest dato=null;
		PreparedStatement ps = null;
		String query = "SELECT count(ht.id_movimiento_ht) as total_documentos, ht.id_movimiento_ht, ht.fecha_registro as fecha_reg, ht.id_unidad_registro, ht.id_hoja_tramite , sum(IF(ar.estado>0,'1','0')) as localizado ,ar.estado,(sum(IF(ar.estado>0,'1','0'))/( count(ht.id_movimiento_ht))) as localizacion_doc  \r\n" + 
				"								FROM movimiento_ht ht \r\n" + 
				"				         left join archivo ar on ar.id_hoja_tramite = ht.id_hoja_tramite \r\n" + 
				"				         \r\n" + 
				"				        where ht.id_estado_movimiento_ht='2' and ht.fecha_registro BETWEEN ? AND DATE_ADD(?, INTERVAL 1 DAY)  and ht.id_unidad_registro=?  \r\n" + 
				"				        group by  DATE_FORMAT(ht.fecha_registro, \"%Y-%m-%d\" ) order by 3 asc";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ps.setString(1, fecha1);
				ps.setString(2, fecha2);
				ps.setInt(3, id_unidad);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<PostTest>();
					rs.beforeFirst();
					while (rs.next()) {
						dato = new PostTest();
						 dato.setFecha(rs.getDate("fecha_reg"));
						 dato.setCant_total(rs.getInt("total_documentos"));
						 dato.setCant_encontrada(rs.getInt("localizado"));
						 dato.setIndicador(rs.getDouble("localizacion_doc"));
						 lista.add(dato);
					}
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query listarLocalización de documentos: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

	@Override
	public List<PostTest> NivelServicio(int id_unidad, String fecha1, String fecha2) {
		List<PostTest> lista = null;
		PostTest dato=null;
		PreparedStatement ps = null;
		String query = "SELECT  count(ht.id_movimiento_ht) as total_documentos,ht.id_movimiento_ht, ht.fecha_registro as fecha_reg, ht.id_unidad_registro, ht.id_hoja_tramite,mov.id_hoja_tramite as maxht, mov.id_estado_movimiento_ht as maxestado,DATE_ADD(ht.fecha_registro, INTERVAL 7 DAY),IF(mov.id_estado_movimiento_ht=8,'1','0'),mov.fecha_registro as fecharegmax, IF(mov.fecha_registro<= DATE_ADD(ht.fecha_registro, INTERVAL 7 DAY),'1','0'), IF(((IF(mov.fecha_registro<= DATE_ADD(ht.fecha_registro, INTERVAL 7 DAY),'1','0'))=(IF(mov.id_estado_movimiento_ht=8,'1','0'))), '1','0' ) AS regla_tramitado_a_tiempo,(sum(IF(((IF(mov.fecha_registro<= DATE_ADD(ht.fecha_registro, INTERVAL 7 DAY),'1','0'))=(IF(mov.id_estado_movimiento_ht=8,'1','0'))), '1','0' ) )) as total_doc_tramit_tiempo, (((sum(IF(((IF(mov.fecha_registro<= DATE_ADD(ht.fecha_registro, INTERVAL 7 DAY),'1','0'))=(IF(mov.id_estado_movimiento_ht=8,'1','0'))), '1','0' ) )))/(count(ht.id_movimiento_ht)))as nivel_servicio\r\n" + 
				"				FROM \r\n" + 
				"        movimiento_ht ht\r\n" + 
				"        inner join (select MAX(id_movimiento_ht) as maximo ,id_estado_movimiento_ht as maxest,fecha_registro, id_hoja_tramite from movimiento_ht group by id_hoja_tramite ) ma on ma.id_hoja_tramite = ht.id_hoja_tramite\r\n" + 
				"        inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n" + 
				"        where ht.id_estado_movimiento_ht='2' and ht.fecha_registro BETWEEN ? AND DATE_ADD(?, INTERVAL 1 DAY) and ht.id_unidad_registro=? \r\n" + 
				"        group by  DATE_FORMAT(ht.fecha_registro, \"%Y-%m-%d\" ) order by 3 asc;";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ps.setString(1, fecha1);
				ps.setString(2, fecha2);
				ps.setInt(3, id_unidad);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<PostTest>();
					rs.beforeFirst();
					while (rs.next()) {
						dato = new PostTest();
						 dato.setFecha(rs.getDate("fecha_reg"));
						 dato.setCant_total(rs.getInt("total_documentos"));
						 dato.setCant_encontrada(rs.getInt("total_doc_tramit_tiempo"));
						 dato.setIndicador(rs.getDouble("nivel_servicio"));
						 lista.add(dato);
					}
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query listarLocalización de documentos: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
		}

}
