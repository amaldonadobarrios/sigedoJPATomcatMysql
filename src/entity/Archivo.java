package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the archivo database table.
 * 
 */
@Entity
@Table(name="archivo")
@NamedQuery(name="Archivo.findAll", query="SELECT a FROM Archivo a")
public class Archivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_archivo")
	private int idArchivo;

	private int estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reg")
	private Date fechaReg;

	@Column(name="id_documento")
	private int idDocumento;

	@Column(name="id_hoja_tramite")
	private int idHojaTramite;

	@Column(name="id_movimiento")
	private int idMovimiento;

	@Column(name="id_unidad")
	private int idUnidad;

	@Column(name="usuario_reg")
	private int usuarioReg;

	@Column(name="id_fichero_archivo")
	private int id_fichero_archivo;
	
	@Column(name="palabras_clave")
	private String palabras_clave;
	
	@Column(name="observaciones")
	private String observaciones;
	
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPalabras_clave() {
		return palabras_clave;
	}

	public void setPalabras_clave(String palabras_clave) {
		this.palabras_clave = palabras_clave;
	}

	public Archivo() {
	}

	public int getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public int getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public int getIdHojaTramite() {
		return this.idHojaTramite;
	}

	public void setIdHojaTramite(int idHojaTramite) {
		this.idHojaTramite = idHojaTramite;
	}

	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public int getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public int getUsuarioReg() {
		return this.usuarioReg;
	}

	public void setUsuarioReg(int usuarioReg) {
		this.usuarioReg = usuarioReg;
	}

	public int getId_fichero_archivo() {
		return id_fichero_archivo;
	}

	public void setId_fichero_archivo(int id_fichero_archivo) {
		this.id_fichero_archivo = id_fichero_archivo;
	}

}