package service.impl;

import java.util.List;

import dao.BandejaDAO;
import dao.impl.BandejaDAOImpl;
import entity.lista.Bandeja;
import service.BandejaService;

public class BandejaServiceImpl implements BandejaService {
BandejaDAO dao=new BandejaDAOImpl();
	@Override
	public List<Bandeja> listaBandeja(int id_estado_movimiento) {
		// TODO Auto-generated method stub
		return dao.listaBandeja(id_estado_movimiento);
	}

}
