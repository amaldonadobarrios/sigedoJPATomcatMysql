package service;

import entity.Documento;

public interface DocumentoService {
	public int GrabarDocumento(Documento doc);

	public Documento ModificarDocumento(Documento doc);

	public Documento CambiarEstadoDocumento(int id_estado, int id_doc);
}
