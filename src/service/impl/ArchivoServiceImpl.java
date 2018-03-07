package service.impl;

import dao.ArchivoDAO;
import dao.impl.ArchivoDAOImpl;
import entity.Archivo;
import service.ArchivoService;

public class ArchivoServiceImpl implements ArchivoService {
ArchivoDAO dao=new ArchivoDAOImpl();
	@Override
	public int save(Archivo obj) {
		// TODO Auto-generated method stub
		return dao.save(obj);
	}

}
