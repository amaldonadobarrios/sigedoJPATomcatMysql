package service.impl;

import dao.HojaTramiteDAO;
import dao.impl.HojaTramiteDAOImpl;
import entity.Codeqr;
import entity.HojaTramite;
import service.HojaTramiteService;

public class HojaTramiteServiceImpl implements HojaTramiteService {
HojaTramiteDAO dao=new HojaTramiteDAOImpl();
	@Override
	public int GrabarHT(HojaTramite obj) {
		// TODO Auto-generated method stub
		return dao.GrabarHT(obj);
	}
	@Override
	public int GrabarIdQR(Codeqr qr) {
		return dao.GrabarIdQR(qr);
	}
	@Override
	public String GrabarImagenQR(Codeqr qr) {
		// TODO Auto-generated method stub
		return dao.GrabarImagenQR(qr);
	}

}
