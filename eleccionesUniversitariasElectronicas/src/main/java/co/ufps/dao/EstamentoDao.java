package co.ufps.dao;

import java.util.List;

import co.ufps.beans.Estamento; 



public interface EstamentoDao {
	public void insert(Estamento es);
public void update(Estamento es);
public void delete(Integer id);
public Estamento select(Integer id);
public List<Estamento> selectAll();

}
