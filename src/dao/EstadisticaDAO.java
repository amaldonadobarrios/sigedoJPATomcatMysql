package dao;

import java.util.List;

import entity.estadistica.EstDocumentoRecibido;
import entity.estadistica.Pretest;

public interface EstadisticaDAO {
	public List<Pretest> listarIndicador2();

	public List<Pretest> listarIndicador1ACTUALLIZADO();

	public List<EstDocumentoRecibido> listarDocRecibido(int id_unidad, String fecha1, String fecha2);
}
