package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_doc database table.
 * 
 */
@Entity
@Table(name="tipo_doc")
@NamedQuery(name="TipoDoc.findAll", query="SELECT t FROM TipoDoc t")
public class TipoDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_doc")
	private int idTipoDoc;

	private String descripcion;

	public TipoDoc() {
	}

	public int getIdTipoDoc() {
		return this.idTipoDoc;
	}

	public void setIdTipoDoc(int idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}