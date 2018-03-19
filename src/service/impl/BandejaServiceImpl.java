package service.impl;

import java.util.List;

import dao.BandejaDAO;
import dao.impl.BandejaDAOImpl;
import entity.lista.Bandeja;
import entity.lista.BandejaArchivador;
import entity.lista.ConsArchivo;
import entity.lista.Trazabilidad;
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
	@Override
	public List<Bandeja> listaBandejaAdministrativoDesaprobados(int id_unidad_destino, int id_usuario) {
		// TODO Auto-generated method stub
		return dao.listaBandejaAdministrativoDesaprobados(id_unidad_destino, id_usuario);
	}
	@Override
	public List<Bandeja> listaBandejaContestados(int estadoBandeja, int id_unidad_Registro) {
		// TODO Auto-generated method stub
		return dao.listaBandejaContestados(estadoBandeja, id_unidad_Registro);
	}
	@Override
	public List<BandejaArchivador> listaBandejaArchivador(int id_unidad, int estado_archivo) {
		// TODO Auto-generated method stub
		return dao.listaBandejaArchivador(id_unidad, estado_archivo);
	}
	@Override
	public List<Trazabilidad> listaTrazabilidad(int id_ht) {
		// TODO Auto-generated method stub
		return dao.listaTrazabilidad(id_ht);
	}
	@Override
	public List<ConsArchivo> listaArchivos(int unidad, String palabra) {
		// TODO Auto-generated method stub
		return dao.listaArchivos(unidad, palabra);
	}

}
