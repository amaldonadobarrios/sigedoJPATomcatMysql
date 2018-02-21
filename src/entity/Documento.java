package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_documento")
	private int idDocumento;

	@Column(name="id_clas_contenido_doc")
	private int idClasContenidoDoc;

	@Column(name="id_clas_funcion_doc")
	private int idClasFuncionDoc;

	@Column(name="id_detalle_doc")
	private int idDetalleDoc;

	@Column(name="id_estado_doc")
	private int idEstadoDoc;

	@Column(name="id_fichero_doc")
	private int idFicheroDoc;

	@Column(name="id_prioridad_doc")
	private int idPrioridadDoc;

	@Column(name="id_tipo_doc")
	private int idTipoDoc;

	public Documento() {
	}

	public int getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public int getIdClasContenidoDoc() {
		return this.idClasContenidoDoc;
	}

	public void setIdClasContenidoDoc(int idClasContenidoDoc) {
		this.idClasContenidoDoc = idClasContenidoDoc;
	}

	public int getIdClasFuncionDoc() {
		return this.idClasFuncionDoc;
	}

	public void setIdClasFuncionDoc(int idClasFuncionDoc) {
		this.idClasFuncionDoc = idClasFuncionDoc;
	}

	public int getIdDetalleDoc() {
		return this.idDetalleDoc;
	}

	public void setIdDetalleDoc(int idDetalleDoc) {
		this.idDetalleDoc = idDetalleDoc;
	}

	public int getIdEstadoDoc() {
		return this.idEstadoDoc;
	}

	public void setIdEstadoDoc(int idEstadoDoc) {
		this.idEstadoDoc = idEstadoDoc;
	}

	public int getIdFicheroDoc() {
		return this.idFicheroDoc;
	}

	public void setIdFicheroDoc(int idFicheroDoc) {
		this.idFicheroDoc = idFicheroDoc;
	}

	public int getIdPrioridadDoc() {
		return this.idPrioridadDoc;
	}

	public void setIdPrioridadDoc(int idPrioridadDoc) {
		this.idPrioridadDoc = idPrioridadDoc;
	}

	public int getIdTipoDoc() {
		return this.idTipoDoc;
	}

	public void setIdTipoDoc(int idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	@Override
	public String toString() {
		return "Documento [idDocumento=" + idDocumento + ", idClasContenidoDoc=" + idClasContenidoDoc
				+ ", idClasFuncionDoc=" + idClasFuncionDoc + ", idDetalleDoc=" + idDetalleDoc + ", idEstadoDoc="
				+ idEstadoDoc + ", idFicheroDoc=" + idFicheroDoc + ", idPrioridadDoc=" + idPrioridadDoc + ", idTipoDoc="
				+ idTipoDoc + "]";
	}

}