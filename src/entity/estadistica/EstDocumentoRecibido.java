package entity.estadistica;

import java.util.Date;

public class EstDocumentoRecibido {
int id_hoja_tramite;
int id_documento;
String documento;
Date fechadoc;
Date fechareg;
String estht;
String  estmax;
Date fecharegmax;
String asunto;
String observaciones;

public int getId_hoja_tramite() {
	return id_hoja_tramite;
}
public void setId_hoja_tramite(int id_hoja_tramite) {
	this.id_hoja_tramite = id_hoja_tramite;
}
public int getId_documento() {
	return id_documento;
}
public void setId_documento(int id_documento) {
	this.id_documento = id_documento;
}
public String getDocumento() {
	return documento;
}
public void setDocumento(String documento) {
	this.documento = documento;
}
public Date getFechadoc() {
	return fechadoc;
}
public void setFechadoc(Date fechadoc) {
	this.fechadoc = fechadoc;
}
public Date getFechareg() {
	return fechareg;
}
public void setFechareg(Date fechareg) {
	this.fechareg = fechareg;
}
public String getEstht() {
	return estht;
}
public void setEstht(String estht) {
	this.estht = estht;
}
public String getEstmax() {
	return estmax;
}
public void setEstmax(String estmax) {
	this.estmax = estmax;
}
public Date getFecharegmax() {
	return fecharegmax;
}
public void setFecharegmax(Date fecharegmax) {
	this.fecharegmax = fecharegmax;
}
public String getAsunto() {
	return asunto;
}
public void setAsunto(String asunto) {
	this.asunto = asunto;
}
public String getObservaciones() {
	return observaciones;
}
public void setObservaciones(String observaciones) {
	this.observaciones = observaciones;
}

}
