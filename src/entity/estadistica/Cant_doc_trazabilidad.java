package entity.estadistica;

public class Cant_doc_trazabilidad {
int cant_recibido;
int cant_derivado;
int cant_respondido;
int cant_aprobado;
int cant_desaprobado;
int cant_devuelto;
int cant_contestado;
int cant_archivado;
int cant_enviado;
public int getCant_recibido() {
	return cant_recibido;
}
public void setCant_recibido(int cant_recibido) {
	this.cant_recibido = cant_recibido;
}
public int getCant_derivado() {
	return cant_derivado;
}
public void setCant_derivado(int cant_derivado) {
	this.cant_derivado = cant_derivado;
}
public int getCant_respondido() {
	return cant_respondido;
}
public void setCant_respondido(int cant_respondido) {
	this.cant_respondido = cant_respondido;
}
public int getCant_aprobado() {
	return cant_aprobado;
}
public void setCant_aprobado(int cant_aprobado) {
	this.cant_aprobado = cant_aprobado;
}
public int getCant_desaprobado() {
	return cant_desaprobado;
}
public void setCant_desaprobado(int cant_desaprobado) {
	this.cant_desaprobado = cant_desaprobado;
}
public int getCant_devuelto() {
	return cant_devuelto;
}
public void setCant_devuelto(int cant_devuelto) {
	this.cant_devuelto = cant_devuelto;
}
public int getCant_contestado() {
	return cant_contestado;
}
public void setCant_contestado(int cant_contestado) {
	this.cant_contestado = cant_contestado;
}
public int getCant_archivado() {
	return cant_archivado;
}
public void setCant_archivado(int cant_archivado) {
	this.cant_archivado = cant_archivado;
}
public int getCant_enviado() {
	return cant_enviado;
}
public void setCant_enviado(int cant_enviado) {
	this.cant_enviado = cant_enviado;
}
@Override
public String toString() {
	return "Cant_doc_trazabilidad [cant_recibido=" + cant_recibido + ", cant_derivado=" + cant_derivado
			+ ", cant_respondido=" + cant_respondido + ", cant_aprobado=" + cant_aprobado + ", cant_desaprobado="
			+ cant_desaprobado + ", cant_devuelto=" + cant_devuelto + ", cant_contestado=" + cant_contestado
			+ ", cant_archivado=" + cant_archivado + ", cant_enviado=" + cant_enviado + "]";
}


}
