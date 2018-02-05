package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oficina database table.
 * 
 */
@Entity
@NamedQuery(name="Oficina.findAll", query="SELECT o FROM Oficina o")
public class Oficina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oficina")
	private int idOficina;

	private String descripcion;

	private int estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_mod")
	private Date fechaMod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_reg")
	private Date fechaReg;

	@Column(name="usu_mod")
	private int usuMod;

	@Column(name="usu_reg")
	private int usuReg;

	public Oficina() {
	}

	public int getIdOficina() {
		return this.idOficina;
	}

	public void setIdOficina(int idOficina) {
		this.idOficina = idOficina;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaMod() {
		return this.fechaMod;
	}

	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public int getUsuMod() {
		return this.usuMod;
	}

	public void setUsuMod(int usuMod) {
		this.usuMod = usuMod;
	}

	public int getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(int usuReg) {
		this.usuReg = usuReg;
	}

}