package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_ht database table.
 * 
 */
@Entity
@Table(name="estado_ht")
@NamedQuery(name="EstadoHt.findAll", query="SELECT e FROM EstadoHt e")
public class EstadoHt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_ht")
	private int idEstadoHt;

	private String descripcion;

	public EstadoHt() {
	}

	public int getIdEstadoHt() {
		return this.idEstadoHt;
	}

	public void setIdEstadoHt(int idEstadoHt) {
		this.idEstadoHt = idEstadoHt;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}