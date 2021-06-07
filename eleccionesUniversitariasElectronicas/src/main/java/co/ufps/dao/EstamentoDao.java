package co.ufps.dao;

import java.util.List;

import co.ufps.beans.Estamento;
import co.ufps.entities.EstamentoEntity; 


public interface EstamentoDao {
	
	public void insert(Estamento es);

	public void insert(EstamentoEntity es);

	public void update(Estamento es);

	public void delete(Integer id);

	public EstamentoEntity select(Integer id);

	public List<Estamento> selectAll();

	public List<Estamento> selectEleccion(int i);

}
