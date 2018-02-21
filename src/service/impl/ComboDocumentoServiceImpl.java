package service.impl;

import java.util.List;

import dao.ComboDocumentoDAO;
import dao.impl.ComboDocumentoDAOImpl;
import entity.ClasContenidoDoc;
import entity.ClasFuncionDoc;
import entity.PrioridadDoc;
import entity.TipoDoc;
import service.ComboDocumentoService;

public class ComboDocumentoServiceImpl implements ComboDocumentoService {
ComboDocumentoDAO dao=new ComboDocumentoDAOImpl();
	@Override
	public List<TipoDoc> ListaTipoDoc() {
		// TODO Auto-generated method stub
		return dao.ListaTipoDoc();
	}

	@Override
	public List<ClasContenidoDoc> ListaClasContenidoDoc() {
		// TODO Auto-generated method stub
		return dao.ListaClasContenidoDoc();
	}

	@Override
	public List<ClasFuncionDoc> ListaClasFuncionDoc() {
		// TODO Auto-generated method stub
		return dao.ListaClasFuncionDoc();
	}

	@Override
	public List<PrioridadDoc> ListaPrioridadDoc() {
		// TODO Auto-generated method stub
		return dao.ListaPrioridadDoc();
	}

}
