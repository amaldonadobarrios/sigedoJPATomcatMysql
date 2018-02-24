package logica;

import entity.Documento;
import service.DocumentoService;
import service.impl.DocumentoServiceImpl;

public class LogicaDocumento {
	// PATRON SINGLETON INI
			private static LogicaDocumento instance = null;

			public static synchronized LogicaDocumento getInstance() {
				if (instance == null) {
					instance = new LogicaDocumento();
				}
				return instance;
			}

			private LogicaDocumento() {
			}
			// PATRON SINGLETON FIN
	public int grabarDocumento(Documento doc) {
	DocumentoService serv=new DocumentoServiceImpl();
	return serv.GrabarDocumento(doc);
	}
	
	public Documento ModificarDocumento(Documento doc) {
		DocumentoService serv=new DocumentoServiceImpl();
		return serv.ModificarDocumento(doc);
	}
	public Documento CambiarEstadoDoc(int estado, int id_doc) {
		DocumentoService serv=new DocumentoServiceImpl();
		return serv.CambiarEstadoDocumento(estado, id_doc);
	}
	
	
}
