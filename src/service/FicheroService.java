package service;

import entity.FicheroDoc;

public interface FicheroService {
	public int Grabar(FicheroDoc obj);
	public String RutaVerPDF(int id_fichero);
	public FicheroDoc Download (int id_fichero);
}
