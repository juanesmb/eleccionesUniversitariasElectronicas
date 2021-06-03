package co.ufps.dao;

import java.util.List;


import co.ufps.beans.Voto;



public interface VotoDao {
	public void insert(Voto es);
public void update(Voto es);
public void delete(Integer id);
public Voto select(Integer id);
public List<Voto> selectAll();

}
