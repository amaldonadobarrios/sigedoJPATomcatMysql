package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clas_funcion_doc database table.
 * 
 */
@Entity
@Table(name="clas_funcion_doc")
@NamedQuery(name="ClasFuncionDoc.findAll", query="SELECT c FROM ClasFuncionDoc c")
public class ClasFuncionDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_clas_funcion_doc")
	private int idClasFuncionDoc;

	private String descripcion;

	public ClasFuncionDoc() {
	}

	public int getIdClasFuncionDoc() {
		return this.idClasFuncionDoc;
	}

	public void setIdClasFuncionDoc(int idClasFuncionDoc) {
		this.idClasFuncionDoc = idClasFuncionDoc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}