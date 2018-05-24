package service;

import java.util.List;

import entity.estadistica.Cant_doc_trazabilidad;
import entity.estadistica.EstDocumentoRecibido;
import entity.estadistica.PostTest;
import entity.estadistica.Pretest;

public interface EstadisticaService {
	
	public List<Pretest> listarIndicador2();
	public List<Pretest> listarIndicador1ACTUALLIZADO();
	public List<EstDocumentoRecibido> listarDocRecibido(int id_unidad, String fecha1, String fecha2);
	public List<PostTest> LocalizacionDocumentos(int id_unidad, String fecha1, String fecha2);
	public List<PostTest> NivelServicio(int id_unidad, String fecha1, String fecha2);
	public Cant_doc_trazabilidad workflow_cantidad();
}
