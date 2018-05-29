package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="dias_vigencia")
	private int diasVigencia;

	private int estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_caducidad")
	private Date fechaCaducidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_mod")
	private Date fechaMod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_reg")
	private Date fechaReg;

	@Column(name="id_perfil")
	private int idPerfil;

	@Column(name="id_persona")
	private int idPersona;

	@Column(name="id_usuario_crea")
	private int idUsuarioCrea;

	@Column(name="id_usuario_mod")
	private int idUsuarioMod;

	private String password;

	private String usuario;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getDiasVigencia() {
		return this.diasVigencia;
	}

	public void setDiasVigencia(int diasVigencia) {
		this.diasVigencia = diasVigencia;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
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

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdUsuarioCrea() {
		return this.idUsuarioCrea;
	}

	public void setIdUsuarioCrea(int idUsuarioCrea) {
		this.idUsuarioCrea = idUsuarioCrea;
	}

	public int getIdUsuarioMod() {
		return this.idUsuarioMod;
	}

	public void setIdUsuarioMod(int idUsuarioMod) {
		this.idUsuarioMod = idUsuarioMod;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", diasVigencia=" + diasVigencia + ", estado=" + estado
				+ ", fechaCaducidad=" + fechaCaducidad + ", fechaMod=" + fechaMod + ", fechaReg=" + fechaReg
				+ ", idPerfil=" + idPerfil + ", idPersona=" + idPersona + ", idUsuarioCrea=" + idUsuarioCrea
				+ ", idUsuarioMod=" + idUsuarioMod + ", password=" + password + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diasVigencia;
		result = prime * result + estado;
		result = prime * result + ((fechaCaducidad == null) ? 0 : fechaCaducidad.hashCode());
		result = prime * result + ((fechaMod == null) ? 0 : fechaMod.hashCode());
		result = prime * result + ((fechaReg == null) ? 0 : fechaReg.hashCode());
		result = prime * result + idPerfil;
		result = prime * result + idPersona;
		result = prime * result + idUsuario;
		result = prime * result + idUsuarioCrea;
		result = prime * result + idUsuarioMod;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (diasVigencia != other.diasVigencia)
			return false;
		if (estado != other.estado)
			return false;
		if (fechaCaducidad == null) {
			if (other.fechaCaducidad != null)
				return false;
		} else if (!fechaCaducidad.equals(other.fechaCaducidad))
			return false;
		if (fechaMod == null) {
			if (other.fechaMod != null)
				return false;
		} else if (!fechaMod.equals(other.fechaMod))
			return false;
		if (fechaReg == null) {
			if (other.fechaReg != null)
				return false;
		} else if (!fechaReg.equals(other.fechaReg))
			return false;
		if (idPerfil != other.idPerfil)
			return false;
		if (idPersona != other.idPersona)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (idUsuarioCrea != other.idUsuarioCrea)
			return false;
		if (idUsuarioMod != other.idUsuarioMod)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}