package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clas_contenido_doc database table.
 * 
 */
@Entity
@Table(name="clas_contenido_doc")
@NamedQuery(name="ClasContenidoDoc.findAll", query="SELECT c FROM ClasContenidoDoc c")
public class ClasContenidoDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_clas_contenido_doc")
	private int idClasContenidoDoc;

	private String descripcion;

	public ClasContenidoDoc() {
	}

	public int getIdClasContenidoDoc() {
		return this.idClasContenidoDoc;
	}

	public void setIdClasContenidoDoc(int idClasContenidoDoc) {
		this.idClasContenidoDoc = idClasContenidoDoc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}