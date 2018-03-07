package service.impl;

import dao.AlmacenArchivoDAO;
import dao.impl.AlmacenArchivoDAOImpl;
import entity.AlmacenArchivo;
import service.AlmacenArchivoService;

public class AlmacenArchivoServiceImpl implements AlmacenArchivoService {
AlmacenArchivoDAO dao= new AlmacenArchivoDAOImpl();
	@Override
	public int save(AlmacenArchivo obj) {
		// TODO Auto-generated method stub
		return dao.save(obj);
	}

}
