package service.impl;

import java.util.List;

import dao.EstadisticaDAO;
import dao.impl.EstadisticaDAOImpl;
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

}
