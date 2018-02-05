package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prioridad_doc database table.
 * 
 */
@Entity
@Table(name="prioridad_doc")
@NamedQuery(name="PrioridadDoc.findAll", query="SELECT p FROM PrioridadDoc p")
public class PrioridadDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_prioridad_doc")
	private int idPrioridadDoc;

	private String descrpcion;

	public PrioridadDoc() {
	}

	public int getIdPrioridadDoc() {
		return this.idPrioridadDoc;
	}

	public void setIdPrioridadDoc(int idPrioridadDoc) {
		this.idPrioridadDoc = idPrioridadDoc;
	}

	public String getDescrpcion() {
		return this.descrpcion;
	}

	public void setDescrpcion(String descrpcion) {
		this.descrpcion = descrpcion;
	}

}