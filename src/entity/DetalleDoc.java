package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_doc database table.
 * 
 */
@Entity
@Table(name="detalle_doc")
@NamedQuery(name="DetalleDoc.findAll", query="SELECT d FROM DetalleDoc d")
public class DetalleDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_doc")
	private int idDetalleDoc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_reg")
	private Date fechaReg;

	@Column(name="id_oficina")
	private int idOficina;

	@Column(name="id_unidad")
	private int idUnidad;

	@Column(name="usu_reg")
	private int usuReg;

	public DetalleDoc() {
	}

	public int getIdDetalleDoc() {
		return this.idDetalleDoc;
	}

	public void setIdDetalleDoc(int idDetalleDoc) {
		this.idDetalleDoc = idDetalleDoc;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public int getIdOficina() {
		return this.idOficina;
	}

	public void setIdOficina(int idOficina) {
		this.idOficina = idOficina;
	}

	public int getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public int getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(int usuReg) {
		this.usuReg = usuReg;
	}

}