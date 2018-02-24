package service.impl;

import dao.DocumentoDAO;
import dao.impl.DocumentoDAOImpl;
import entity.Documento;
import service.DocumentoService;

public class DocumentoServiceImpl implements DocumentoService {
DocumentoDAO dao= new DocumentoDAOImpl();
	@Override
	public int GrabarDocumento(Documento doc) {
		// TODO Auto-generated method stub
		return dao.GrabarDocumento(doc);
	}

	@Override
	public Documento ModificarDocumento(Documento doc) {
		// TODO Auto-generated method stub
		return dao.ModificarDocumento(doc);
	}

	@Override
	public Documento CambiarEstadoDocumento(int id_estado, int id_doc) {
		// TODO Auto-generated method stub
		return dao.CambiarEstadoDocumento(id_estado, id_doc);
	}

}
