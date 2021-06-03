package co.ufps.dao;

import java.util.List;

import co.ufps.beans.Eleccion;

public interface EleccionDao {
	
	public void insert(Eleccion e);
	public void update(Eleccion e);
	public void delete(Integer id);
	public Eleccion select(Integer id);
	public List<Eleccion> selectAll();
	
}
