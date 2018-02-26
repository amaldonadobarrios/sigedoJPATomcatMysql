package entity.lista;

import java.util.Date;

public class Bandeja {
	int id_movimiento;
	int id_hoja_tramite;
	int id_documento;
	int id_fichero;
	int id_prioridad;
	int id_documento_ini;
	String asunto;
	String estado_mov;
	String observaciones;
	String documento;
	Date fecha_doc;
	Date fecha_reg;

	public int getId_movimiento() {
		return id_movimiento;
	}

	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}

	public int getId_hoja_tramite() {
		return id_hoja_tramite;
	}

	public void setId_hoja_tramite(int id_hoja_tramite) {
		this.id_hoja_tramite = id_hoja_tramite;
	}

	public int getId_documento() {
		return id_documento;
	}

	public void setId_documento(int id_documento) {
		this.id_documento = id_documento;
	}

	public int getId_fichero() {
		return id_fichero;
	}

	public void setId_fichero(int id_fichero) {
		this.id_fichero = id_fichero;
	}

	public int getId_prioridad() {
		return id_prioridad;
	}

	public void setId_prioridad(int id_prioridad) {
		this.id_prioridad = id_prioridad;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getEstado_mov() {
		return estado_mov;
	}

	public void setEstado_mov(String estado_mov) {
		this.estado_mov = estado_mov;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFecha_doc() {
		return fecha_doc;
	}

	public void setFecha_doc(Date fecha_doc) {
		this.fecha_doc = fecha_doc;
	}

	public Date getFecha_reg() {
		return fecha_reg;
	}

	public void setFecha_reg(Date fecha_reg) {
		this.fecha_reg = fecha_reg;
	}

	public int getId_documento_ini() {
		return id_documento_ini;
	}

	public void setId_documento_ini(int id_documento_ini) {
		this.id_documento_ini = id_documento_ini;
	}

}
