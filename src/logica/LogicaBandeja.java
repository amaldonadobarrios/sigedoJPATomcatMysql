package logica;

import java.util.List;

import entity.lista.Bandeja;
import entity.lista.BandejaArchivador;
import entity.lista.Trazabilidad;
import service.BandejaService;
import service.impl.BandejaServiceImpl;

public class LogicaBandeja {
	// PATRON SINGLETON INI
	private static LogicaBandeja instance = null;

	public static synchronized LogicaBandeja getInstance() {
		if (instance == null) {
			instance = new LogicaBandeja();
		}
		return instance;
	}

	private LogicaBandeja() {
	}
	// PATRON SINGLETON FIN

	public List<Bandeja> ListarBandeja(int estadoBandeja,int id_unidad_destino) {
		BandejaService serv = new BandejaServiceImpl();
		List<Bandeja> bandeja = null;
		bandeja = serv.listaBandeja(estadoBandeja,id_unidad_destino);
		return bandeja;
	}
	public List<Bandeja> ListarBandejaAdministrativo(int id_unidad_destino,int id_usuario) {
		BandejaService serv = new BandejaServiceImpl();
		List<Bandeja> bandeja = null;
		bandeja = serv.listaBandejaAdministrativo(id_unidad_destino, id_usuario);
		return bandeja;
	}
	public List<Bandeja> ListarBandejaAdministrativoDesaprobado(int id_unidad_destino,int id_usuario) {
		BandejaService serv = new BandejaServiceImpl();
		List<Bandeja> bandeja = null;
		bandeja = serv.listaBandejaAdministrativoDesaprobados(id_unidad_destino, id_usuario);
		return bandeja;
	}
	public List<Bandeja> ListarBandejaContestados(int estadoBandeja,int id_unidad_Registro) {
		BandejaService serv = new BandejaServiceImpl();
		List<Bandeja> bandeja = null;
		bandeja = serv.listaBandejaContestados(estadoBandeja,id_unidad_Registro);
		return bandeja;
	}
	public List<BandejaArchivador> ListarBandejaArchivador(int id_unidad,int estado_archivo) {
		BandejaService serv = new BandejaServiceImpl();
		List<BandejaArchivador> bandeja = null;
		bandeja = serv.listaBandejaArchivador(id_unidad, estado_archivo);
		return bandeja;
	}
	public List<Trazabilidad> ListarTrazabilidad(int id_ht) {
		BandejaService serv = new BandejaServiceImpl();
		List<Trazabilidad> bandeja = null;
		bandeja = serv.listaTrazabilidad(id_ht);
		return bandeja;
	}
}
