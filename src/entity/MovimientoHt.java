package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the movimiento_ht database table.
 * 
 */
@Entity
@Table(name="movimiento_ht")
@NamedQuery(name="MovimientoHt.findAll", query="SELECT m FROM MovimientoHt m")
public class MovimientoHt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movimiento_ht")
	private int idMovimientoHt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="id_usuario_destino")
	private int id_usuarioDestino;

	@Column(name="id_documento")
	private int idDocumento;

	@Column(name="id_estado_movimiento_ht")
	private int idEstadoMovimientoHt;

	@Column(name="id_hoja_tramite")
	private int idHojaTramite;

	@Column(name="id_oficina_destino")
	private int idOficinaDestino;

	@Column(name="id_oficina_registro")
	private int idOficinaRegistro;

	@Column(name="id_unidad_destino")
	private int idUnidadDestino;

	@Column(name="id_unidad_registro")
	private int idUnidadRegistro;

	@Column(name="id_usuario_registro")
	private int idUsuarioRegistro;

	@Column(name="observaciones")
	private String observaciones;
	
	public MovimientoHt() {
	}

	public int getIdMovimientoHt() {
		return this.idMovimientoHt;
	}

	public void setIdMovimientoHt(int idMovimientoHt) {
		this.idMovimientoHt = idMovimientoHt;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getId_usuarioDestino() {
		return this.id_usuarioDestino;
	}

	public void setId_usuarioDestino(int id_usuarioDestino) {
		this.id_usuarioDestino = id_usuarioDestino;
	}

	public int getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public int getIdEstadoMovimientoHt() {
		return this.idEstadoMovimientoHt;
	}

	public void setIdEstadoMovimientoHt(int idEstadoMovimientoHt) {
		this.idEstadoMovimientoHt = idEstadoMovimientoHt;
	}

	public int getIdHojaTramite() {
		return this.idHojaTramite;
	}

	public void setIdHojaTramite(int idHojaTramite) {
		this.idHojaTramite = idHojaTramite;
	}

	public int getIdOficinaDestino() {
		return this.idOficinaDestino;
	}

	public void setIdOficinaDestino(int idOficinaDestino) {
		this.idOficinaDestino = idOficinaDestino;
	}

	public int getIdOficinaRegistro() {
		return this.idOficinaRegistro;
	}

	public void setIdOficinaRegistro(int idOficinaRegistro) {
		this.idOficinaRegistro = idOficinaRegistro;
	}

	public int getIdUnidadDestino() {
		return this.idUnidadDestino;
	}

	public void setIdUnidadDestino(int idUnidadDestino) {
		this.idUnidadDestino = idUnidadDestino;
	}

	public int getIdUnidadRegistro() {
		return this.idUnidadRegistro;
	}

	public void setIdUnidadRegistro(int idUnidadRegistro) {
		this.idUnidadRegistro = idUnidadRegistro;
	}

	public int getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(int idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}