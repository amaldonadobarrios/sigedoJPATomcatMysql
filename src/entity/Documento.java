package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_documento")
	private int idDocumento;

	@Column(name = "id_clas_contenido_doc")
	private int idClasContenidoDoc;

	@Column(name = "id_clas_funcion_doc")
	private int idClasFuncionDoc;

	@Column(name = "id_estado_doc")
	private int idEstadoDoc;

	@Column(name = "id_fichero_doc")
	private int idFicheroDoc;

	@Column(name = "id_prioridad_doc")
	private int idPrioridadDoc;

	@Column(name = "id_tipo_doc")
	private int idTipoDoc;

	@Column(name = "asunto")
	private String asunto;

	@Column(name = "siglas")
	private String siglas;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_doc")
	private Date fecha;

	@Column(name = "numero")
	private String numero;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_reg")
	private Date fechaReg;

	@Column(name = "id_unidad_remite")
	private int idUnidad;

	@Column(name = "usu_reg")
	private int usuReg;

	@Column(name = "id_unidad_registra")
	private int idUnidadReg;
	
	@Column(name = "id_unidad_documental")
	private int id_unidad_documental;
	
	public Documento() {
	}

	public int getId_unidad_documental() {
		return id_unidad_documental;
	}

	public void setId_unidad_documental(int id_unidad_documental) {
		this.id_unidad_documental = id_unidad_documental;
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

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public int getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public int getUsuReg() {
		return usuReg;
	}

	public void setUsuReg(int usuReg) {
		this.usuReg = usuReg;
	}

	public int getIdUnidadReg() {
		return idUnidadReg;
	}

	public void setIdUnidadReg(int idUnidadReg) {
		this.idUnidadReg = idUnidadReg;
	}

	@Override
	public String toString() {
		return "Documento [idDocumento=" + idDocumento + ", idClasContenidoDoc=" + idClasContenidoDoc
				+ ", idClasFuncionDoc=" + idClasFuncionDoc + ", idEstadoDoc=" + idEstadoDoc + ", idFicheroDoc="
				+ idFicheroDoc + ", idPrioridadDoc=" + idPrioridadDoc + ", idTipoDoc=" + idTipoDoc + ", asunto="
				+ asunto + ", siglas=" + siglas + ", fecha=" + fecha + ", numero=" + numero + ", fechaReg=" + fechaReg
				+ ", idUnidad=" + idUnidad + ", usuReg=" + usuReg + ", idUnidadReg=" + idUnidadReg + "]";
	}



}