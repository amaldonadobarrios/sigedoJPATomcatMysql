package service.impl;

import dao.GraficoDAO;
import dao.impl.GraficoDAOImpl;
import service.GraficoService;

public class GraficoServiceImpl implements GraficoService {
GraficoDAO dao=new GraficoDAOImpl();
	@Override
	public String totArchivosAnio(int id_unidad) {
		// TODO Auto-generated method stub
		return dao.totArchivosAnio(id_unidad);
	}

	@Override
	public String totArchivosMesAnioActual(int id_unidad) {
		// TODO Auto-generated method stub
		return dao.totArchivosMesAnioActual(id_unidad);
	}

	@Override
	public String TopAdministrativoMasRanking(int id_unidad) {
		// TODO Auto-generated method stub
		return dao.TopAdministrativoMasRanking(id_unidad);
	}

	@Override
	public String TopUsuarioSistema(int id_unidad) {
		// TODO Auto-generated method stub
		return dao.TopUsuarioSistema(id_unidad);
	}

}
