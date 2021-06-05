package co.ufps.dao;

import java.util.List;

import co.ufps.beans.Eleccion;
import co.ufps.entities.EleccionEntity;

public interface EleccionDao {
	
	public void insert(Eleccion e);
	public void insert(EleccionEntity e);
	public void update(Eleccion e);
	public void delete(Integer id);
	public EleccionEntity select(Integer id);
	public List<Eleccion> selectAll();
	
}
