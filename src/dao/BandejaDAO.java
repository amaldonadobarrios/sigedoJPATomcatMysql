package dao;

import java.util.List;

import entity.lista.Bandeja;
import entity.lista.BandejaArchivador;

public interface BandejaDAO {
public List<Bandeja> listaBandeja(int id_estado_movimiento, int id_unidad_destino);
public List<Bandeja> listaBandejaAdministrativo(int id_unidad_destino, int id_usuario);
public List<Bandeja> listaBandejaAdministrativoDesaprobados(int id_unidad_destino, int id_usuario);
public List<Bandeja> listaBandejaContestados(int estadoBandeja, int id_unidad_Registro);
public List<BandejaArchivador> listaBandejaArchivador(int id_unidad, int estado_archivo);
}
