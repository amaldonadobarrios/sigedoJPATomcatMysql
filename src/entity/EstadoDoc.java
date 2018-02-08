package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_doc database table.
 * 
 */
@Entity
@Table(name="estado_doc")
@NamedQuery(name="EstadoDoc.findAll", query="SELECT e FROM EstadoDoc e")
public class EstadoDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_doc")
	private int idEstadoDoc;

	private String descripcion;

	public EstadoDoc() {
	}

	public int getIdEstadoDoc() {
		return this.idEstadoDoc;
	}

	public void setIdEstadoDoc(int idEstadoDoc) {
		this.idEstadoDoc = idEstadoDoc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}