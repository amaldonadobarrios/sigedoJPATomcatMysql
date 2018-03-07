package dao;

import java.util.List;

import entity.lista.Bandeja;

public interface BandejaDAO {
public List<Bandeja> listaBandeja(int id_estado_movimiento, int id_unidad_destino);
public List<Bandeja> listaBandejaAdministrativo(int id_unidad_destino, int id_usuario);
}
