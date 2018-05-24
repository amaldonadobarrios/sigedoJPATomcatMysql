package entity.estadistica;

public class Grafic_Trazabilidad {

	int id_hoja_tramite;
	String Frecibido;
	String Fderivado;
	String Frespondido;
	String Faprobado;
	String Fdesaprobado;
	String Fdevuelto;
	String Fcontestado;
	String Farchivado;
	String Fenviado;
	String deriv_recibido;
	String respondido_derivado;
	String devuelto_derivado;
	String aprobado_respondido;
	String desaprobado_respondido;
	String contestado_aprobado;
	String archivado_contestado;
	String Total_dias;
	public int getId_hoja_tramite() {
		return id_hoja_tramite;
	}
	public void setId_hoja_tramite(int id_hoja_tramite) {
		this.id_hoja_tramite = id_hoja_tramite;
	}
	public String getFrecibido() {
		return Frecibido;
	}
	public void setFrecibido(String frecibido) {
		Frecibido = frecibido;
	}
	public String getFderivado() {
		return Fderivado;
	}
	public void setFderivado(String fderivado) {
		Fderivado = fderivado;
	}
	public String getFrespondido() {
		return Frespondido;
	}
	public void setFrespondido(String frespondido) {
		Frespondido = frespondido;
	}
	public String getFaprobado() {
		return Faprobado;
	}
	public void setFaprobado(String faprobado) {
		Faprobado = faprobado;
	}
	public String getFdesaprobado() {
		return Fdesaprobado;
	}
	public void setFdesaprobado(String fdesaprobado) {
		Fdesaprobado = fdesaprobado;
	}
	public String getFdevuelto() {
		return Fdevuelto;
	}
	public void setFdevuelto(String fdevuelto) {
		Fdevuelto = fdevuelto;
	}
	public String getFcontestado() {
		return Fcontestado;
	}
	public void setFcontestado(String fcontestado) {
		Fcontestado = fcontestado;
	}
	public String getFarchivado() {
		return Farchivado;
	}
	public void setFarchivado(String farchivado) {
		Farchivado = farchivado;
	}
	public String getFenviado() {
		return Fenviado;
	}
	public void setFenviado(String fenviado) {
		Fenviado = fenviado;
	}
	public String getDeriv_recibido() {
		return deriv_recibido;
	}
	public void setDeriv_recibido(String deriv_recibido) {
		this.deriv_recibido = deriv_recibido;
	}
	public String getRespondido_derivado() {
		return respondido_derivado;
	}
	public void setRespondido_derivado(String respondido_derivado) {
		this.respondido_derivado = respondido_derivado;
	}
	public String getDevuelto_derivado() {
		return devuelto_derivado;
	}
	public void setDevuelto_derivado(String devuelto_derivado) {
		this.devuelto_derivado = devuelto_derivado;
	}
	public String getAprobado_respondido() {
		return aprobado_respondido;
	}
	public void setAprobado_respondido(String aprobado_respondido) {
		this.aprobado_respondido = aprobado_respondido;
	}
	public String getDesaprobado_respondido() {
		return desaprobado_respondido;
	}
	public void setDesaprobado_respondido(String desaprobado_respondido) {
		this.desaprobado_respondido = desaprobado_respondido;
	}
	public String getContestado_aprobado() {
		return contestado_aprobado;
	}
	public void setContestado_aprobado(String contestado_aprobado) {
		this.contestado_aprobado = contestado_aprobado;
	}
	public String getArchivado_contestado() {
		return archivado_contestado;
	}
	public void setArchivado_contestado(String archivado_contestado) {
		this.archivado_contestado = archivado_contestado;
	}
	public String getTotal_dias() {
		return Total_dias;
	}
	public void setTotal_dias(String total_dias) {
		Total_dias = total_dias;
	}
	@Override
	public String toString() {
		return "Grafic_Trazabilidad [id_hoja_tramite=" + id_hoja_tramite + ", Frecibido=" + Frecibido + ", Fderivado="
				+ Fderivado + ", Frespondido=" + Frespondido + ", Faprobado=" + Faprobado + ", Fdesaprobado="
				+ Fdesaprobado + ", Fdevuelto=" + Fdevuelto + ", Fcontestado=" + Fcontestado + ", Farchivado="
				+ Farchivado + ", Fenviado=" + Fenviado + ", deriv_recibido=" + deriv_recibido
				+ ", respondido_derivado=" + respondido_derivado + ", devuelto_derivado=" + devuelto_derivado
				+ ", aprobado_respondido=" + aprobado_respondido + ", desaprobado_respondido=" + desaprobado_respondido
				+ ", contestado_aprobado=" + contestado_aprobado + ", archivado_contestado=" + archivado_contestado
				+ ", Total_dias=" + Total_dias + "]";
	}
	
	
}
