package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

	@Column(name="perfil_id_perfil")
	private int perfilIdPerfil;

	@Column(name="persona_id_persona")
	private int personaIdPersona;

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

	public int getPerfilIdPerfil() {
		return this.perfilIdPerfil;
	}

	public void setPerfilIdPerfil(int perfilIdPerfil) {
		this.perfilIdPerfil = perfilIdPerfil;
	}

	public int getPersonaIdPersona() {
		return this.personaIdPersona;
	}

	public void setPersonaIdPersona(int personaIdPersona) {
		this.personaIdPersona = personaIdPersona;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}