package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fichero_doc database table.
 * 
 */
@Entity
@Table(name="fichero_doc")
@NamedQuery(name="FicheroDoc.findAll", query="SELECT f FROM FicheroDoc f")
public class FicheroDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_fichero_doc")
	private int idFicheroDoc;

	@Lob
	private byte[] blob;

	private int estado;

	private String nombre;

	private String size;

	private String tipo;

	public FicheroDoc() {
	}

	public int getIdFicheroDoc() {
		return this.idFicheroDoc;
	}

	public void setIdFicheroDoc(int idFicheroDoc) {
		this.idFicheroDoc = idFicheroDoc;
	}

	public byte[] getBlob() {
		return this.blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}