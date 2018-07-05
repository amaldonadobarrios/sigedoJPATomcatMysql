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
import entity.lista.Bandeja;
import entity.lista.BandejaArchivador;
import entity.lista.ConsArchivo;
import entity.lista.Trazabilidad;

public class BandejaDAOImpl implements BandejaDAO {

	@Override
	public List<Bandeja> listaBandeja(int id_estado_movimiento, int id_unidad_destino) {
		Bandeja temp = null;
		List<Bandeja> lista = null;
		PreparedStatement ps = null;
		String query = "SELECT  ma.maximo as id_movimiento \r\n" + "				,mov.id_hoja_tramite,\r\n"
				+ "				 mov.id_documento,\r\n" + "				 mov.id_usuario_registro,\r\n"
				+ "				 mov.id_unidad_registro,\r\n" + "				 mov.id_oficina_registro,\r\n"
				+ "				ht.asunto,\r\n" + "				  emov.descripcion as estado_mov,\r\n"
				+ "				 mov.observaciones,\r\n" + "				doc.id_fichero_doc,\r\n"
				+ "				doc.id_prioridad_doc,\r\n"
				+ "				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n"
				+ "				doc.fecha_doc ,\r\n" + "				 mov.fecha_registro,\r\n"
				+ "				 docini.id_fichero_doc as id_fichero_ini,\r\n"
				+ "				ht.id_documento_inicio \r\n"
				+ "				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n"
				+ "				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n"
				+ "				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n"
				+ "				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n"
				+ "				join documento doc on mov.id_documento=doc.id_documento\r\n"
				+ "				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n"
				+ "				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n"
				+ "				where mov.id_estado_movimiento_ht=? and mov.id_unidad_destino=? ";
		String queryDerivado = "SELECT  ma.maximo as id_movimiento \r\n" + "				,mov.id_hoja_tramite,\r\n"
				+ "				 mov.id_documento,\r\n" + "				 mov.id_usuario_registro,\r\n"
				+ "				 mov.id_unidad_registro,\r\n" + "				 mov.id_oficina_registro,\r\n"
				+ "				ht.asunto,\r\n" + "				  emov.descripcion as estado_mov,\r\n"
				+ "				 mov.observaciones,\r\n" + "				doc.id_fichero_doc,\r\n"
				+ "				doc.id_prioridad_doc,\r\n"
				+ "				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n"
				+ "				doc.fecha_doc ,\r\n" + "				 mov.fecha_registro,\r\n"
				+ "				 docini.id_fichero_doc as id_fichero_ini,\r\n"
				+ "				ht.id_documento_inicio,\r\n" + "        mov.id_usuario_destino,\r\n"
				+ "        mov.id_oficina_destino,\r\n" + "        mov.id_unidad_destino,\r\n"
				+ "        uni.descripcion as unidad_destino,\r\n" + "        ofi.descripcion as oficina_destino,\r\n"
				+ "        concat(per.grado,\" \", per.ape_pat,\" \", per.ape_mat,\" \", per.nombres) as des_usureg\r\n"
				+ "				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n"
				+ "				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n"
				+ "				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n"
				+ "				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n"
				+ "				join documento doc on mov.id_documento=doc.id_documento\r\n"
				+ "				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n"
				+ "				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n"
				+ "        join usuario usu on usu.id_usuario=mov.id_usuario_destino\r\n"
				+ "        join persona per on per.id_persona=usu.id_persona\r\n"
				+ "        join unidad uni on uni.id_unidad = mov.id_unidad_destino\r\n"
				+ "        join oficina ofi on ofi.id_oficina = mov.id_oficina_destino\r\n"
				+ "				where mov.id_estado_movimiento_ht=? and mov.id_unidad_destino=?";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				if (id_estado_movimiento == 3) {
					ps = cn.prepareStatement(queryDerivado);
				} else {
					ps = cn.prepareStatement(query);
				}
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
						if (id_estado_movimiento == 3) {
							temp.setId_usuario_destino(rs.getInt(17));
							temp.setId_oficina_destino(rs.getInt(18));
							temp.setId_unidad_destino(rs.getInt(19));
							temp.setUni_destino(rs.getString(20));
							temp.setOfi_destino(rs.getString(21));
							temp.setPersona_destino(rs.getString(22));
						}
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
	public List<Bandeja> listaBandejaAdministrativo(int id_unidad_destino, int id_usuario) {
		Bandeja temp = null;
		List<Bandeja> lista = null;
		PreparedStatement ps = null;
		String queryDerivado = "SELECT  ma.maximo as id_movimiento \r\n" + "				,mov.id_hoja_tramite,\r\n"
				+ "				 mov.id_documento,\r\n" + "				 mov.id_usuario_registro,\r\n"
				+ "				 mov.id_unidad_registro,\r\n" + "				 mov.id_oficina_registro,\r\n"
				+ "				ht.asunto,\r\n" + "				  emov.descripcion as estado_mov,\r\n"
				+ "				 mov.observaciones,\r\n" + "				doc.id_fichero_doc,\r\n"
				+ "				doc.id_prioridad_doc,\r\n"
				+ "				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n"
				+ "				doc.fecha_doc ,\r\n" + "				 mov.fecha_registro,\r\n"
				+ "				 docini.id_fichero_doc as id_fichero_ini,\r\n"
				+ "				ht.id_documento_inicio,\r\n" + "        mov.id_usuario_destino,\r\n"
				+ "        mov.id_oficina_destino,\r\n" + "        mov.id_unidad_destino,\r\n"
				+ "        uni.descripcion as unidad_destino,\r\n" + "        ofi.descripcion as oficina_destino,\r\n"
				+ "        concat(per.grado,\" \", per.ape_pat,\" \", per.ape_mat,\" \", per.nombres) as des_usureg\r\n"
				+ "				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n"
				+ "				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n"
				+ "				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n"
				+ "				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n"
				+ "				join documento doc on mov.id_documento=doc.id_documento\r\n"
				+ "				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n"
				+ "				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n"
				+ "        join usuario usu on usu.id_usuario=mov.id_usuario_destino\r\n"
				+ "        join persona per on per.id_persona=usu.id_persona\r\n"
				+ "        join unidad uni on uni.id_unidad = mov.id_unidad_destino\r\n"
				+ "        join oficina ofi on ofi.id_oficina = mov.id_oficina_destino\r\n"
				+ "				where mov.id_unidad_destino=? and mov.id_usuario_destino=? and mov.id_estado_movimiento_ht=3";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(queryDerivado);
				ps.setInt(1, id_unidad_destino);
				ps.setInt(2, id_usuario);
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
						temp.setId_usuario_destino(rs.getInt(17));
						temp.setId_oficina_destino(rs.getInt(18));
						temp.setId_unidad_destino(rs.getInt(19));
						temp.setUni_destino(rs.getString(20));
						temp.setOfi_destino(rs.getString(21));
						temp.setPersona_destino(rs.getString(22));
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
	public List<Bandeja> listaBandejaAdministrativoDesaprobados(int id_unidad_destino, int id_usuario) {
		Bandeja temp = null;
		List<Bandeja> lista = null;
		PreparedStatement ps = null;
		String query = "SELECT  ma.maximo as id_movimiento \r\n" + "				,mov.id_hoja_tramite,\r\n"
				+ "				 mov.id_documento,\r\n" + "				 mov.id_usuario_registro,\r\n"
				+ "				 mov.id_unidad_registro,\r\n" + "				 mov.id_oficina_registro,\r\n"
				+ "				ht.asunto,\r\n" + "				  emov.descripcion as estado_mov,\r\n"
				+ "				 mov.observaciones,\r\n" + "				doc.id_fichero_doc,\r\n"
				+ "				doc.id_prioridad_doc,\r\n"
				+ "				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n"
				+ "				doc.fecha_doc ,\r\n" + "				 mov.fecha_registro,\r\n"
				+ "				 docini.id_fichero_doc as id_fichero_ini,\r\n"
				+ "				ht.id_documento_inicio \r\n"
				+ "				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n"
				+ "				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n"
				+ "				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n"
				+ "				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n"
				+ "				join documento doc on mov.id_documento=doc.id_documento\r\n"
				+ "				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n"
				+ "				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n"
				+ "				where mov.id_estado_movimiento_ht=6 and mov.id_unidad_destino=? and mov.id_usuario_destino=? ";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ps.setInt(1, id_unidad_destino);
				ps.setInt(2, id_usuario);
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

	@Override
	public List<Bandeja> listaBandejaContestados(int estadoBandeja, int id_unidad_Registro) {
		Bandeja temp = null;
		List<Bandeja> lista = null;
		PreparedStatement ps = null;
		String query = "SELECT  ma.maximo as id_movimiento \r\n" + "				,mov.id_hoja_tramite,\r\n"
				+ "				 mov.id_documento,\r\n" + "				 mov.id_usuario_registro,\r\n"
				+ "				 mov.id_unidad_registro,\r\n" + "				 mov.id_oficina_registro,\r\n"
				+ "				ht.asunto,\r\n" + "				  emov.descripcion as estado_mov,\r\n"
				+ "				 mov.observaciones,\r\n" + "				doc.id_fichero_doc,\r\n"
				+ "				doc.id_prioridad_doc,\r\n"
				+ "				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n"
				+ "				doc.fecha_doc ,\r\n" + "				 mov.fecha_registro,\r\n"
				+ "				 docini.id_fichero_doc as id_fichero_ini,\r\n"
				+ "				ht.id_documento_inicio \r\n"
				+ "				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n"
				+ "				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n"
				+ "				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n"
				+ "				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n"
				+ "				join documento doc on mov.id_documento=doc.id_documento\r\n"
				+ "				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n"
				+ "				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n"
				+ "				where mov.id_estado_movimiento_ht=? and mov.id_unidad_registro=?";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ps.setInt(1, estadoBandeja);
				ps.setInt(2, id_unidad_Registro);
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

	@Override
	public List<BandejaArchivador> listaBandejaArchivador(int id_unidad, int estado_archivo) {
		BandejaArchivador temp = null;
		List<BandejaArchivador> lista = null;
		PreparedStatement ps = null;
		String query = "SELECT ar.id_archivo,\r\n" + "ar.id_hoja_tramite, \r\n" + "ar.id_documento, \r\n"
				+ "ar.id_movimiento, \r\n" + "ar.fecha_reg,\r\n" + "ar.usuario_reg,\r\n" + "ar.estado,\r\n"
				+ "ar.id_unidad,\r\n" + "ar.id_fichero_archivo,\r\n" + "doc.asunto,\r\n"
				+ "doc.fecha_doc as fechadoc,\r\n" + "mov.observaciones,\r\n" + "doc.id_fichero_doc,\r\n"
				+ "concat(tdoc.descripcion,\" N°\",doc.numero,\" \",doc.siglas) as documento, " + " ar.palabras_clave,"
				+ " ar.observaciones as obsdigitalizacion " + "FROM archivo ar \r\n"
				+ "inner join documento doc on doc.id_documento=ar.id_documento\r\n"
				+ "join tipo_doc tdoc on tdoc.id_tipo_doc=doc.id_tipo_doc\r\n"
				+ "join movimiento_ht mov on mov.id_movimiento_ht=ar.id_movimiento\r\n"
				+ "where ar.id_unidad=? and  ar.estado=? ";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ps.setInt(1, id_unidad);
				ps.setInt(2, estado_archivo);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<BandejaArchivador>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new BandejaArchivador();
						temp.setId_archivo(rs.getInt(1));
						temp.setId_hoja_tramite(rs.getInt(2));
						temp.setId_documento(rs.getInt(3));
						temp.setId_movimiento(rs.getInt(4));
						temp.setFecha_reg(rs.getDate(5));
						temp.setId_usuario_reg(rs.getInt(6));
						temp.setId_estado(rs.getInt(7));
						temp.setId_unidad_reg(rs.getInt(8));
						temp.setId_fichero_archivo(rs.getInt(9));
						temp.setAsunto(rs.getString(10));
						temp.setFecha_doc(rs.getDate(11));
						temp.setObservaciones(rs.getString(12));
						temp.setId_fichero(rs.getInt(13));
						temp.setDocumento(rs.getString(14));
						temp.setPalabras(rs.getString(15));
						temp.setObservacionesDigitalizacion(rs.getString(16));
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
	public List<Trazabilidad> listaTrazabilidad(int id_ht) {
		Trazabilidad temp = null;
		List<Trazabilidad> lista = null;
		PreparedStatement ps = null;
		String query = "SELECT mov.id_movimiento_ht, mov.fecha_registro,  mov.id_hoja_tramite, \r\n" + 
				"				mov.id_documento,  mov.id_estado_movimiento_ht, \r\n" + 
				"				mov.observaciones as obs_movimiento, emov.descripcion as desc_movimiento,\r\n" + 
				"				doc.asunto, concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento ,\r\n" + 
				"				uniorigen.descripcion as  uni_reg, ofireg.descripcion as ofi_reg,\r\n" + 
				"				IFNULL(ofides.descripcion,\"INTERNO\") as oficinaDestino,\r\n" + 
				"				unidestino.descripcion as Destino, eht.descripcion as estadoht,\r\n" + 
				"				concat(perreg.grado,' ', perreg.ape_pat,' ', perreg.ape_mat,' ', perreg.nombres) as usu_registra ,\r\n" + 
				"				IFNULL(concat(perdes.grado,' ', perdes.ape_pat,' ', perdes.ape_mat,' ', perdes.nombres), \"INTERNO\") AS usu_destino,\r\n" + 
				"				doc.id_fichero_doc, IF(arc.estado='1',\"DIGITALIZADO\",\"ORIGINAL\") as estadoarchivo,\r\n" + 
				"				arc.id_fichero_archivo  AS id_fichero_archivo,\r\n" + 
				"				IFNULL(arc.observaciones ,\"INTERNO\")as obsarchivo, doc.fecha_doc, hoja.id_hoja_tramite as ht_ini, hoja.fecha_registro as fecha_ini, hoja.asunto as asunto_ini, pri.descripcion as prioridad_ini, concat(tdocini.descripcion,' N°',docini.numero,' ',docini.siglas) as documento_ini, movini.observaciones as observaciones_ini \r\n" + 
				"				FROM movimiento_ht mov\r\n" + 
				"				inner join estado_movimiento_ht emov on emov.id_estado_movimiento_ht=mov.id_estado_movimiento_ht\r\n" + 
				"				join documento doc on doc.id_documento=mov.id_documento\r\n" + 
				"				join tipo_doc tdoc on tdoc.id_tipo_doc=doc.id_tipo_doc\r\n" + 
				"				join unidad uniorigen on uniorigen.id_unidad=mov.id_unidad_registro\r\n" + 
				"				join unidad unidestino on unidestino.id_unidad=mov.id_unidad_destino\r\n" + 
				"				join oficina ofireg on ofireg.id_oficina=mov.id_oficina_registro\r\n" + 
				"				left join oficina ofides on ofides.id_oficina=mov.id_oficina_destino                                                                                                                                                                                \r\n" + 
				"				join hoja_tramite ht on ht.id_hoja_tramite = mov.id_hoja_tramite\r\n" + 
				"				join estado_ht eht on eht.id_estado_ht = ht.id_estado_ht\r\n" + 
				"				join usuario usureg on usureg.id_usuario=mov.id_usuario_registro\r\n" + 
				"				join persona perreg on perreg.id_persona=usureg.id_persona\r\n" + 
				"				left join usuario usudes on usudes.id_usuario=mov.id_usuario_destino\r\n" + 
				"				left join persona perdes on perdes.id_persona=usudes.id_persona\r\n" + 
				"				left join archivo arc on arc.id_movimiento=mov.id_movimiento_ht\r\n" + 
				"        join hoja_tramite hoja on mov.id_hoja_tramite = hoja.id_hoja_tramite\r\n" + 
				"        left join documento docini on docini.id_documento = hoja.id_documento_inicio\r\n" + 
				"        left join tipo_doc tdocini on docini.id_tipo_doc = tdocini.id_tipo_doc\r\n" + 
				"        left join movimiento_ht movini on movini.id_hoja_tramite = hoja.id_hoja_tramite and movini.id_estado_movimiento_ht='2'\r\n" + 
				"        left join prioridad_doc pri on docini.id_prioridad_doc = pri.id_prioridad_doc\r\n" + 
				"				where hoja.id_hoja_tramite=? order by 1 asc";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				ps.setInt(1, id_ht);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<Trazabilidad>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new Trazabilidad();
						temp.setId_mov_ht(rs.getInt(1));
						temp.setFecha_reg(rs.getDate(2));
						temp.setId_ht(rs.getInt(3));
						temp.setId_doc(rs.getInt(4));
						temp.setId_est_mov_ht(rs.getInt(5));
						temp.setObs_movimiento(rs.getString(6));
						temp.setDesc_movimiento(rs.getString(7));
						temp.setAsunto_doc(rs.getString(8));
						temp.setDocumento(rs.getString(9));
						temp.setUni_reg(rs.getString(10));
						temp.setOfi_reg(rs.getString(11));
						temp.setOfi_des(rs.getString(12));
						temp.setUni_des(rs.getString(13));
						temp.setEstadoht(rs.getString(14));
						temp.setUsu_reg(rs.getString(15));
						temp.setUsu_des(rs.getString(16));
						temp.setId_fichero(rs.getInt(17));
						temp.setEstado_archivo(rs.getString(18));
						temp.setId_fichero_archivo(rs.getInt(19));
						temp.setObs_archivo(rs.getString(20));
						temp.setFechadoc(rs.getDate(21));
						temp.setHt_ini(rs.getInt(22));
						temp.setFecha_ini(rs.getDate(23));
						temp.setAsunto_ini(rs.getString(24));
						temp.setPrioridad_ini(rs.getString(25));
						temp.setDocumento_ini(rs.getString(26));
						temp.setObservaciones_ini(rs.getString(27));
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
	public List<ConsArchivo> listaArchivos(int unidad, String palabra) {
		ConsArchivo temp = null;
		List<ConsArchivo> lista = null;
		PreparedStatement ps = null;
		String [] palabrasarray = palabra.trim().split(" ");
		int npalabras=palabrasarray.length;
		String ParametroQuery="";
		if (npalabras>1) {
			for (int i = 0; i < palabrasarray.length; i++) {
				ParametroQuery=ParametroQuery +" ar.palabras_clave like concat('%',?,'%')";
				if (i<palabrasarray.length-1) {
					ParametroQuery=ParametroQuery+" OR ";
				}
			}	
		} else {
			ParametroQuery="ar.palabras_clave like concat('%',?,'%')";
		}
		System.out.println("PARAMETRO QUERY "+ParametroQuery);
		System.out.println("NUMERO DE PALABRAS :" +npalabras);
		String query = "SELECT ar.id_archivo,\r\n" + "ar.id_hoja_tramite,\r\n" + "ar.fecha_reg,\r\n"
				+ "ar.id_unidad, \r\n" + "ar.id_fichero_archivo,  \r\n" + "ar.observaciones,\r\n"
				+ "concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n" + "doc.fecha_doc,\r\n"
				+ "doc.asunto,\r\n"
				+ "concat(perreg.grado,' ', perreg.ape_pat,' ', perreg.ape_mat,' ', perreg.nombres) as usu_registra ,\r\n"
				+ "al.etiqueta_archivador as archivador,\r\n" + "al.year_archivador as anyoarchivador,\r\n"
				+ "al.secuencia_archivador as secuenciaarchivo,\r\n" + "al.observaciones as obsarchivo\r\n"
				+ "FROM archivo ar\r\n" + "inner join almacen_archivo al on al.id_archivo = ar.id_archivo\r\n"
				+ "join documento doc on doc.id_documento=ar.id_documento\r\n"
				+ "join tipo_doc tdoc on tdoc.id_tipo_doc=doc.id_tipo_doc\r\n"
				+ "join usuario usureg on usureg.id_usuario=ar.usuario_reg\r\n"
				+ "join persona perreg on perreg.id_persona=usureg.id_persona\r\n"
				+ "where "
				+ ParametroQuery+"  and ar.estado='1' and ar.id_unidad=? or doc.asunto like concat('%',?,'%') or ar.observaciones like concat('%',?,'%') order by 1 asc";
//ar.palabras_clave like concat('%',REPLACE(?,' ','%'),'%')
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				ps = cn.prepareStatement(query);
				for (int i = 0; i < palabrasarray.length; i++) {
					ps.setString(i+1, palabrasarray[i]);	
				}
				//ps.setString(1, palabra);
				
				ps.setInt(npalabras+1, unidad);//2
				ps.setString(npalabras+2, palabra);//3
				ps.setString(npalabras+3, palabra);//4
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					lista = new ArrayList<ConsArchivo>();
					rs.beforeFirst();
					while (rs.next()) {
						temp = new ConsArchivo();
						temp.setId_archivo(rs.getInt(1));
						temp.setId_hoja_tramite(rs.getInt(2));
						temp.setFecha_reg(rs.getDate(3));
						temp.setId_unidad(rs.getInt(4));
						temp.setId_fichero_archivo(rs.getInt(5));
						temp.setObservaciones(rs.getString(6));
						temp.setDocumento(rs.getString(7));
						temp.setFecha_doc(rs.getDate(8));
						temp.setAsunto(rs.getString(9));
						temp.setUsu_reg(rs.getString(10));
						temp.setArchivador(rs.getString(11));
						temp.setAnyoarchivador(rs.getString(12));
						temp.setSecuencia(rs.getString(13));
						temp.setObservacionArchivo(rs.getString(14));
						lista.add(temp);
					}
				}

			} catch (SQLException e) {
				System.out.println("Excepcion en query listaArchivos: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return lista;
	}

}
