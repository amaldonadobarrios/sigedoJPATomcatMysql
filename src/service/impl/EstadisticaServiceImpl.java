package service.impl;

import java.util.List;

import dao.EstadisticaDAO;
import dao.impl.EstadisticaDAOImpl;
import entity.estadistica.EstDocumentoRecibido;
import entity.estadistica.PostTest;
import entity.estadistica.Pretest;
import service.EstadisticaService;

public class EstadisticaServiceImpl implements EstadisticaService {
EstadisticaDAO dao=new EstadisticaDAOImpl();
	

	@Override
	public List<Pretest> listarIndicador2() {
		// TODO Auto-generated method stub
		return dao.listarIndicador2();
	}

	@Override
	public List<Pretest> listarIndicador1ACTUALLIZADO() {
		// TODO Auto-generated method stub
		return dao.listarIndicador1ACTUALLIZADO();
	}

	@Override
	public List<EstDocumentoRecibido> listarDocRecibido(int id_unidad, String fecha1, String fecha2) {
		// TODO Auto-generated method stub
		return dao.listarDocRecibido(id_unidad, fecha1, fecha2);
	}

	@Override
	public List<PostTest> LocalizacionDocumentos(int id_unidad, String fecha1, String fecha2) {
		// TODO Auto-generated method stub
		return dao.LocalizacionDocumentos(id_unidad, fecha1, fecha2);
	}

	@Override
	public List<PostTest> NivelServicio(int id_unidad, String fecha1, String fecha2) {
		// TODO Auto-generated method stub
		return dao.NivelServicio(id_unidad, fecha1, fecha2);
	}

}
