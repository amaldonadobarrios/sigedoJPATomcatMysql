package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_ht database table.
 * 
 */
@Entity
@Table(name="detalle_ht")
@NamedQuery(name="DetalleHt.findAll", query="SELECT d FROM DetalleHt d")
public class DetalleHt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_ht")
	private int idDetalleHt;

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

	public DetalleHt() {
	}

	public int getIdDetalleHt() {
		return this.idDetalleHt;
	}

	public void setIdDetalleHt(int idDetalleHt) {
		this.idDetalleHt = idDetalleHt;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdOficinaRegistro() {
		return this.idOficinaRegistro;
	}

	public void setIdOficinaRegistro(int idOficinaRegistro) {
		this.idOficinaRegistro = idOficinaRegistro;
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

}