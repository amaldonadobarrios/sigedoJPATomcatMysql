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

}
