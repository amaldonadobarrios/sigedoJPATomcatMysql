package dao;

import java.util.List;

import entity.Oficina;

public interface OficinaDAO {
public int save(Oficina obj);
public Oficina Buscarxid(int id);
public List<Oficina> Listar();
}
