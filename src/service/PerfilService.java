package service;

import java.util.List;

import entity.Perfil;

public interface PerfilService {
	public Perfil BuscarxId(int id);
	public  List<Perfil> Listar();
}
