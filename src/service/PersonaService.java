package service;

import entity.Persona;

public interface PersonaService {
	public Persona BuscarxId(int id);
	public Persona GrabarPersona(Persona obj);
	public Persona BuscarxCip(String  cip);
	public Persona ModificarPersona(Persona obj);
}
