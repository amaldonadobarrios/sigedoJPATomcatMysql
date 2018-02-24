package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the hoja_tramite database table.
 * 
 */
@Entity
@Table(name="hoja_tramite")
@NamedQuery(name="HojaTramite.findAll", query="SELECT h FROM HojaTramite h")
public class HojaTramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_hoja_tramite")
	private int idHojaTramite;
	
	@Column(name="id_documento_inicio")
	private int idDocumentoInicio;
	
	@Column(name="id_estado_ht")
	private int idEstadoHt;
	
	@Column(name="asunto")
	private String asunto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="id_oficina_registro")
	private int idOficinaRegistro;

	@Column(name="id_unidad_registro")
	private int idUnidadRegistro;

	@Column(name="id_usuario_registro")
	private int idUsuarioRegistro;
	
	@Column(name="id_unidad_destino")
	private int idUnidadDestino;
	
	
	
	public int getIdUnidadDestino() {
		return idUnidadDestino;
	}

	public void setIdUnidadDestino(int idUnidadDestino) {
		this.idUnidadDestino = idUnidadDestino;
	}

	public HojaTramite() {
	}

	public int getIdHojaTramite() {
		return this.idHojaTramite;
	}

	public void setIdHojaTramite(int idHojaTramite) {
		this.idHojaTramite = idHojaTramite;
	}

	public int getIdEstadoHt() {
		return this.idEstadoHt;
	}

	public void setIdEstadoHt(int idEstadoHt) {
		this.idEstadoHt = idEstadoHt;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdOficinaRegistro() {
		return idOficinaRegistro;
	}

	public void setIdOficinaRegistro(int idOficinaRegistro) {
		this.idOficinaRegistro = idOficinaRegistro;
	}

	public int getIdUnidadRegistro() {
		return idUnidadRegistro;
	}

	public void setIdUnidadRegistro(int idUnidadRegistro) {
		this.idUnidadRegistro = idUnidadRegistro;
	}

	public int getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(int idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public int getIdDocumentoInicio() {
		return idDocumentoInicio;
	}

	public void setIdDocumentoInicio(int idDocumentoInicio) {
		this.idDocumentoInicio = idDocumentoInicio;
	}

	@Override
	public String toString() {
		return "HojaTramite [idHojaTramite=" + idHojaTramite + ", idDocumentoInicio=" + idDocumentoInicio
				+ ", idEstadoHt=" + idEstadoHt + ", asunto=" + asunto + ", fechaRegistro=" + fechaRegistro
				+ ", idOficinaRegistro=" + idOficinaRegistro + ", idUnidadRegistro=" + idUnidadRegistro
				+ ", idUsuarioRegistro=" + idUsuarioRegistro + ", idUnidadDestino=" + idUnidadDestino + "]";
	}





}