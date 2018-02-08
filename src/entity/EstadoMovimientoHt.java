package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_movimiento_ht database table.
 * 
 */
@Entity
@Table(name="estado_movimiento_ht")
@NamedQuery(name="EstadoMovimientoHt.findAll", query="SELECT e FROM EstadoMovimientoHt e")
public class EstadoMovimientoHt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_movimiento_ht")
	private int idEstadoMovimientoHt;

	private String descripcion;

	public EstadoMovimientoHt() {
	}

	public int getIdEstadoMovimientoHt() {
		return this.idEstadoMovimientoHt;
	}

	public void setIdEstadoMovimientoHt(int idEstadoMovimientoHt) {
		this.idEstadoMovimientoHt = idEstadoMovimientoHt;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}