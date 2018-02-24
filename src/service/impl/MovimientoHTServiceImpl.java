package service.impl;

import dao.MovimientoHTDAO;
import dao.impl.MovimientoHTDAOImpl;
import entity.MovimientoHt;
import service.MovimientoHTService;

public class MovimientoHTServiceImpl implements MovimientoHTService {
	MovimientoHTDAO dao = new MovimientoHTDAOImpl();

	@Override
	public int GrabarMovimientoHT(MovimientoHt MHT) {
		// TODO Auto-generated method stub
		return dao.GrabarMovimientoHT(MHT);
	}

}
