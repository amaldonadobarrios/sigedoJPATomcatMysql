package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the centro_trabajo database table.
 * 
 */
@Entity
@Table(name="centro_trabajo")
@NamedQuery(name="CentroTrabajo.findAll", query="SELECT c FROM CentroTrabajo c")
public class CentroTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_centro_trabajo")
	private int idCentroTrabajo;

	private int estado;

	@Column(name="id_oficina")
	private int idOficina;

	@Column(name="id_unidad")
	private int idUnidad;

	public CentroTrabajo() {
	}

	public int getIdCentroTrabajo() {
		return this.idCentroTrabajo;
	}

	public void setIdCentroTrabajo(int idCentroTrabajo) {
		this.idCentroTrabajo = idCentroTrabajo;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdOficina() {
		return this.idOficina;
	}

	public void setIdOficina(int idOficina) {
		this.idOficina = idOficina;
	}

	public int getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

}