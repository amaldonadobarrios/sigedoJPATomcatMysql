package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cuadro_clasificacion database table.
 * 
 */
@Entity
@Table(name="cuadro_clasificacion")
@NamedQuery(name="CuadroClasificacion.findAll", query="SELECT c FROM CuadroClasificacion c")
public class CuadroClasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cuadro")
	private int idCuadro;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reg")
	private Date fechaReg;

	@Column(name="id_oficina")
	private int idOficina;

	@Column(name="unidad_documental")
	private String unidadDocumental;

	public CuadroClasificacion() {
	}

	public int getIdCuadro() {
		return this.idCuadro;
	}

	public void setIdCuadro(int idCuadro) {
		this.idCuadro = idCuadro;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public int getIdOficina() {
		return this.idOficina;
	}

	public void setIdOficina(int idOficina) {
		this.idOficina = idOficina;
	}

	public String getUnidadDocumental() {
		return this.unidadDocumental;
	}

	public void setUnidadDocumental(String unidadDocumental) {
		this.unidadDocumental = unidadDocumental;
	}

}