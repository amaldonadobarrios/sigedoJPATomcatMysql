package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EstadisticaDAO;
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

}
