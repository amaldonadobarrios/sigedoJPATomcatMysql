package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the codeqr database table.
 * 
 */
@Entity
@NamedQuery(name = "Codeqr.findAll", query = "SELECT c FROM Codeqr c")
public class Codeqr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_codigoQr;
	@Lob
	@Column(name = "codeQr", nullable = true)
	private byte[] codeQr;

	private int id_Hoja_tramite;

	public Codeqr() {
	}

	public int getId_codigoQr() {
		return this.id_codigoQr;
	}

	public void setId_codigoQr(int id_codigoQr) {
		this.id_codigoQr = id_codigoQr;
	}

	public byte[] getCodeQr() {
		return codeQr;
	}

	public void setCodeQr(byte[] codeQr) {
		this.codeQr = codeQr;
	}

	public int getId_Hoja_tramite() {
		return this.id_Hoja_tramite;
	}

	public void setId_Hoja_tramite(int id_Hoja_tramite) {
		this.id_Hoja_tramite = id_Hoja_tramite;
	}

}