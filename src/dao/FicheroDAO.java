package dao;

import entity.FicheroDoc;

public interface FicheroDAO {

	public int Grabar(FicheroDoc obj);
	public String RutaVerPDF(int id_fichero);
	public FicheroDoc Download (int id_fichero);
}
