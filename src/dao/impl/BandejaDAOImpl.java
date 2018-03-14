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
import entity.lista.BandejaArchivador;

public class BandejaDAOImpl implements BandejaDAO {

	@Override
	public List<Bandeja> listaBandeja(int id_estado_movimiento, int id_unidad_destino) {
		Bandeja temp = null;
		List<Bandeja> lista = null;
		PreparedStatement ps =null;
		String query="SELECT  ma.maximo as id_movimiento \r\n" + 
				"				,mov.id_hoja_tramite,\r\n" + 
				"				 mov.id_documento,\r\n" + 
				"				 mov.id_usuario_registro,\r\n" + 
				"				 mov.id_unidad_registro,\r\n" + 
				"				 mov.id_oficina_registro,\r\n" + 
				"				ht.asunto,\r\n" + 
				"				  emov.descripcion as estado_mov,\r\n" + 
				"				 mov.observaciones,\r\n" + 
				"				doc.id_fichero_doc,\r\n" + 
				"				doc.id_prioridad_doc,\r\n" + 
				"				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n" + 
				"				doc.fecha_doc ,\r\n" + 
				"				 mov.fecha_registro,\r\n" + 
				"				 docini.id_fichero_doc as id_fichero_ini,\r\n" + 
				"				ht.id_documento_inicio \r\n" + 
				"				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n" + 
				"				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n" + 
				"				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n" + 
				"				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n" + 
				"				join documento doc on mov.id_documento=doc.id_documento\r\n" + 
				"				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n" + 
				"				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n" + 
				"				where mov.id_estado_movimiento_ht=? and mov.id_unidad_destino=? ";
		String queryDerivado  = "SELECT  ma.maximo as id_movimiento \r\n" + 
				"				,mov.id_hoja_tramite,\r\n" + 
				"				 mov.id_documento,\r\n" + 
				"				 mov.id_usuario_registro,\r\n" + 
				"				 mov.id_unidad_registro,\r\n" + 
				"				 mov.id_oficina_registro,\r\n" + 
				"				ht.asunto,\r\n" + 
				"				  emov.descripcion as estado_mov,\r\n" + 
				"				 mov.observaciones,\r\n" + 
				"				doc.id_fichero_doc,\r\n" + 
				"				doc.id_prioridad_doc,\r\n" + 
				"				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n" + 
				"				doc.fecha_doc ,\r\n" + 
				"				 mov.fecha_registro,\r\n" + 
				"				 docini.id_fichero_doc as id_fichero_ini,\r\n" + 
				"				ht.id_documento_inicio,\r\n" + 
				"        mov.id_usuario_destino,\r\n" + 
				"        mov.id_oficina_destino,\r\n" + 
				"        mov.id_unidad_destino,\r\n" + 
				"        uni.descripcion as unidad_destino,\r\n" + 
				"        ofi.descripcion as oficina_destino,\r\n" + 
				"        concat(per.grado,\" \", per.ape_pat,\" \", per.ape_mat,\" \", per.nombres) as des_usureg\r\n" + 
				"				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n" + 
				"				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n" + 
				"				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n" + 
				"				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n" + 
				"				join documento doc on mov.id_documento=doc.id_documento\r\n" + 
				"				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n" + 
				"				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n" + 
				"        join usuario usu on usu.id_usuario=mov.id_usuario_destino\r\n" + 
				"        join persona per on per.id_persona=usu.id_persona\r\n" + 
				"        join unidad uni on uni.id_unidad = mov.id_unidad_destino\r\n" + 
				"        join oficina ofi on ofi.id_oficina = mov.id_oficina_destino\r\n" + 
				"				where mov.id_estado_movimiento_ht=? and mov.id_unidad_destino=?";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwSigedo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				if (id_estado_movimiento==3) {
					 ps = cn.prepareStatement(queryDerivado);
				}else {
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
						if (id_estado_movimiento==3) {
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
		PreparedStatement ps =null;
		String queryDerivado  = "SELECT  ma.maximo as id_movimiento \r\n" + 
				"				,mov.id_hoja_tramite,\r\n" + 
				"				 mov.id_documento,\r\n" + 
				"				 mov.id_usuario_registro,\r\n" + 
				"				 mov.id_unidad_registro,\r\n" + 
				"				 mov.id_oficina_registro,\r\n" + 
				"				ht.asunto,\r\n" + 
				"				  emov.descripcion as estado_mov,\r\n" + 
				"				 mov.observaciones,\r\n" + 
				"				doc.id_fichero_doc,\r\n" + 
				"				doc.id_prioridad_doc,\r\n" + 
				"				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n" + 
				"				doc.fecha_doc ,\r\n" + 
				"				 mov.fecha_registro,\r\n" + 
				"				 docini.id_fichero_doc as id_fichero_ini,\r\n" + 
				"				ht.id_documento_inicio,\r\n" + 
				"        mov.id_usuario_destino,\r\n" + 
				"        mov.id_oficina_destino,\r\n" + 
				"        mov.id_unidad_destino,\r\n" + 
				"        uni.descripcion as unidad_destino,\r\n" + 
				"        ofi.descripcion as oficina_destino,\r\n" + 
				"        concat(per.grado,\" \", per.ape_pat,\" \", per.ape_mat,\" \", per.nombres) as des_usureg\r\n" + 
				"				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n" + 
				"				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n" + 
				"				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n" + 
				"				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n" + 
				"				join documento doc on mov.id_documento=doc.id_documento\r\n" + 
				"				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n" + 
				"				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n" + 
				"        join usuario usu on usu.id_usuario=mov.id_usuario_destino\r\n" + 
				"        join persona per on per.id_persona=usu.id_persona\r\n" + 
				"        join unidad uni on uni.id_unidad = mov.id_unidad_destino\r\n" + 
				"        join oficina ofi on ofi.id_oficina = mov.id_oficina_destino\r\n" + 
				"				where mov.id_unidad_destino=? and mov.id_usuario_destino=? and mov.id_estado_movimiento_ht=3";
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
						}
						lista.add(temp);
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
		PreparedStatement ps =null;
		String query="SELECT  ma.maximo as id_movimiento \r\n" + 
				"				,mov.id_hoja_tramite,\r\n" + 
				"				 mov.id_documento,\r\n" + 
				"				 mov.id_usuario_registro,\r\n" + 
				"				 mov.id_unidad_registro,\r\n" + 
				"				 mov.id_oficina_registro,\r\n" + 
				"				ht.asunto,\r\n" + 
				"				  emov.descripcion as estado_mov,\r\n" + 
				"				 mov.observaciones,\r\n" + 
				"				doc.id_fichero_doc,\r\n" + 
				"				doc.id_prioridad_doc,\r\n" + 
				"				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n" + 
				"				doc.fecha_doc ,\r\n" + 
				"				 mov.fecha_registro,\r\n" + 
				"				 docini.id_fichero_doc as id_fichero_ini,\r\n" + 
				"				ht.id_documento_inicio \r\n" + 
				"				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n" + 
				"				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n" + 
				"				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n" + 
				"				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n" + 
				"				join documento doc on mov.id_documento=doc.id_documento\r\n" + 
				"				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n" + 
				"				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n" + 
				"				where mov.id_estado_movimiento_ht=6 and mov.id_unidad_destino=? and mov.id_usuario_destino=? ";
		
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
		PreparedStatement ps =null;
		String query="SELECT  ma.maximo as id_movimiento \r\n" + 
				"				,mov.id_hoja_tramite,\r\n" + 
				"				 mov.id_documento,\r\n" + 
				"				 mov.id_usuario_registro,\r\n" + 
				"				 mov.id_unidad_registro,\r\n" + 
				"				 mov.id_oficina_registro,\r\n" + 
				"				ht.asunto,\r\n" + 
				"				  emov.descripcion as estado_mov,\r\n" + 
				"				 mov.observaciones,\r\n" + 
				"				doc.id_fichero_doc,\r\n" + 
				"				doc.id_prioridad_doc,\r\n" + 
				"				 concat(tdoc.descripcion,' N°',doc.numero,' ',doc.siglas) as documento,\r\n" + 
				"				doc.fecha_doc ,\r\n" + 
				"				 mov.fecha_registro,\r\n" + 
				"				 docini.id_fichero_doc as id_fichero_ini,\r\n" + 
				"				ht.id_documento_inicio \r\n" + 
				"				FROM (select MAX(mvht.id_movimiento_ht) as maximo ,mvht.id_estado_movimiento_ht as maxest from movimiento_ht mvht group by mvht.id_hoja_tramite ) ma \r\n" + 
				"				inner join movimiento_ht  mov  on ma.maximo=mov.id_movimiento_ht \r\n" + 
				"				join hoja_tramite ht on ht.id_hoja_tramite=mov.id_hoja_tramite \r\n" + 
				"				join estado_movimiento_ht emov on mov.id_estado_movimiento_ht=emov.id_estado_movimiento_ht \r\n" + 
				"				join documento doc on mov.id_documento=doc.id_documento\r\n" + 
				"				join documento docini on ht.id_documento_inicio=docini.id_documento \r\n" + 
				"				join tipo_doc tdoc on doc.id_tipo_doc=tdoc.id_tipo_doc \r\n" + 
				"				where mov.id_estado_movimiento_ht=? and mov.id_unidad_registro=?";
		
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
		PreparedStatement ps =null;
		String query="SELECT ar.id_archivo,\r\n" + 
				"ar.id_hoja_tramite, \r\n" + 
				"ar.id_documento, \r\n" + 
				"ar.id_movimiento, \r\n" + 
				"ar.fecha_reg,\r\n" + 
				"ar.usuario_reg,\r\n" + 
				"ar.estado,\r\n" + 
				"ar.id_unidad,\r\n" + 
				"ar.id_fichero_archivo,\r\n" + 
				"doc.asunto,\r\n" + 
				"doc.fecha_doc as fechadoc,\r\n" + 
				"mov.observaciones,\r\n" + 
				"doc.id_fichero_doc,\r\n" + 
				"concat(tdoc.descripcion,\" N°\",doc.numero,\" \",doc.siglas) as documento, "
				+ " ar.palabras_clave,"
				+ " ar.observaciones as obsdigitalizacion " + 
				"FROM archivo ar \r\n" + 
				"inner join documento doc on doc.id_documento=ar.id_documento\r\n" + 
				"join tipo_doc tdoc on tdoc.id_tipo_doc=doc.id_tipo_doc\r\n" + 
				"join movimiento_ht mov on mov.id_movimiento_ht=ar.id_movimiento\r\n" + 
				"where ar.id_unidad=? and  ar.estado=? ";
		
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

}
