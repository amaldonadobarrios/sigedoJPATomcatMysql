package entity.lista;

import java.util.Date;

public class Bandeja {
	int id_movimiento;
	int id_hoja_tramite;
	int id_documento;
	int id_usuario_registro;
	int id_unidad_registro;
	int id_oficina_registro;
	int id_fichero;
	int id_prioridad;
	int id_documento_ini;
	int id_fichero_ini;
	String asunto;
	String estado_mov;
	String observaciones;
	String documento;
	Date fecha_doc;
	Date fecha_reg;
	int id_usuario_destino;
	int id_oficina_destino;
	int id_unidad_destino;
	String ofi_destino;
	String uni_destino;
	String persona_destino;
	

	public int getId_usuario_destino() {
		return id_usuario_destino;
	}

	public void setId_usuario_destino(int id_usuario_destino) {
		this.id_usuario_destino = id_usuario_destino;
	}

	public int getId_oficina_destino() {
		return id_oficina_destino;
	}

	public void setId_oficina_destino(int id_oficina_destino) {
		this.id_oficina_destino = id_oficina_destino;
	}

	public int getId_unidad_destino() {
		return id_unidad_destino;
	}

	public void setId_unidad_destino(int id_unidad_destino) {
		this.id_unidad_destino = id_unidad_destino;
	}

	public String getOfi_destino() {
		return ofi_destino;
	}

	public void setOfi_destino(String ofi_destino) {
		this.ofi_destino = ofi_destino;
	}

	public String getUni_destino() {
		return uni_destino;
	}

	public void setUni_destino(String uni_destino) {
		this.uni_destino = uni_destino;
	}

	public String getPersona_destino() {
		return persona_destino;
	}

	public void setPersona_destino(String persona_destino) {
		this.persona_destino = persona_destino;
	}

	public int getId_usuario_registro() {
		return id_usuario_registro;
	}

	public void setId_usuario_registro(int id_usuario_registro) {
		this.id_usuario_registro = id_usuario_registro;
	}

	public int getId_unidad_registro() {
		return id_unidad_registro;
	}

	public void setId_unidad_registro(int id_unidad_registro) {
		this.id_unidad_registro = id_unidad_registro;
	}

	public int getId_oficina_registro() {
		return id_oficina_registro;
	}

	public void setId_oficina_registro(int id_ofcina_registro) {
		this.id_oficina_registro = id_ofcina_registro;
	}

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

	public int getId_fichero_ini() {
		return id_fichero_ini;
	}

	public void setId_fichero_ini(int id_fichero_ini) {
		this.id_fichero_ini = id_fichero_ini;
	}

}
