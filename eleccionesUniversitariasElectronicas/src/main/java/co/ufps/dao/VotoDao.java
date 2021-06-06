package co.ufps.dao;

import java.util.List;


import co.ufps.beans.Voto;
import co.ufps.entities.VotoEntity;



public interface VotoDao {
	public void insert(Voto es);
	public void insert(VotoEntity es);
public void update(Voto es);
public void delete(Integer id);
public Voto select(Integer id);
public List<Voto> selectAll();

}
