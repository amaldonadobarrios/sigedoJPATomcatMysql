package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the almacen_archivo database table.
 * 
 */
@Entity
@Table(name="almacen_archivo")
@NamedQuery(name="AlmacenArchivo.findAll", query="SELECT a FROM AlmacenArchivo a")
public class AlmacenArchivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_almacen_documento")
	private int idAlmacenDocumento;

	@Column(name="etiqueta_archivador")
	private String etiquetaArchivador;

	@Column(name="id_archivador_oficina")
	private int idArchivadorOficina;

	@Column(name="id_archivo")
	private int idArchivo;

	private String observaciones;

	@Column(name="secuencia_archivador")
	private String secuenciaArchivador;

	@Column(name="year_archivador")
	private String yearArchivador;

	public AlmacenArchivo() {
	}

	public int getIdAlmacenDocumento() {
		return this.idAlmacenDocumento;
	}

	public void setIdAlmacenDocumento(int idAlmacenDocumento) {
		this.idAlmacenDocumento = idAlmacenDocumento;
	}

	public String getEtiquetaArchivador() {
		return this.etiquetaArchivador;
	}

	public void setEtiquetaArchivador(String etiquetaArchivador) {
		this.etiquetaArchivador = etiquetaArchivador;
	}

	public int getIdArchivadorOficina() {
		return this.idArchivadorOficina;
	}

	public void setIdArchivadorOficina(int idArchivadorOficina) {
		this.idArchivadorOficina = idArchivadorOficina;
	}

	public int getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getSecuenciaArchivador() {
		return this.secuenciaArchivador;
	}

	public void setSecuenciaArchivador(String secuenciaArchivador) {
		this.secuenciaArchivador = secuenciaArchivador;
	}

	public String getYearArchivador() {
		return this.yearArchivador;
	}

	public void setYearArchivador(String yearArchivador) {
		this.yearArchivador = yearArchivador;
	}

}