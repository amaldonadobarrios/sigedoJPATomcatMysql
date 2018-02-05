package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hoja_tramite database table.
 * 
 */
@Entity
@Table(name="hoja_tramite")
@NamedQuery(name="HojaTramite.findAll", query="SELECT h FROM HojaTramite h")
public class HojaTramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_hoja_tramite")
	private int idHojaTramite;

	@Column(name="id_detalle_ht")
	private int idDetalleHt;

	@Column(name="id_estado_ht")
	private int idEstadoHt;

	public HojaTramite() {
	}

	public int getIdHojaTramite() {
		return this.idHojaTramite;
	}

	public void setIdHojaTramite(int idHojaTramite) {
		this.idHojaTramite = idHojaTramite;
	}

	public int getIdDetalleHt() {
		return this.idDetalleHt;
	}

	public void setIdDetalleHt(int idDetalleHt) {
		this.idDetalleHt = idDetalleHt;
	}

	public int getIdEstadoHt() {
		return this.idEstadoHt;
	}

	public void setIdEstadoHt(int idEstadoHt) {
		this.idEstadoHt = idEstadoHt;
	}

}