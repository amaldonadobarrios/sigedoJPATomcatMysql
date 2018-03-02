package service.impl;

import dao.FicheroDAO;
import dao.impl.FicheroDAOImpl;
import entity.FicheroDoc;
import service.FicheroService;

public class FicheroServiceImpl implements FicheroService {
	FicheroDAO dao = new FicheroDAOImpl();

	@Override
	public int Grabar(FicheroDoc obj) {
		return dao.Grabar(obj);
	}

	@Override
	public String RutaVerPDF(int id_fichero) {
		// TODO Auto-generated method stub
		return dao.RutaVerPDF(id_fichero);
	}

	@Override
	public FicheroDoc Download(int id_fichero) {
		// TODO Auto-generated method stub
		return dao.Download(id_fichero);
	}

}
