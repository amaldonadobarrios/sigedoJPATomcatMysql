package service.impl;

import java.util.List;

import dao.BandejaDAO;
import dao.impl.BandejaDAOImpl;
import entity.lista.Bandeja;
import service.BandejaService;

public class BandejaServiceImpl implements BandejaService {
BandejaDAO dao=new BandejaDAOImpl();
	@Override
	public List<Bandeja> listaBandeja(int id_estado_movimiento,int id_unidad_destino) {
		// TODO Auto-generated method stub
		return dao.listaBandeja(id_estado_movimiento, id_unidad_destino);
	}
	@Override
	public List<Bandeja> listaBandejaAdministrativo(int id_unidad_destino, int id_usuario) {
		// TODO Auto-generated method stub
		return dao.listaBandejaAdministrativo(id_unidad_destino, id_usuario);
	}

}
