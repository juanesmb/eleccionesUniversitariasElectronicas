package co.ufps.dao;

import java.util.List;


import co.ufps.beans.Votante;
import co.ufps.entities.VotanteEntity;



public interface VotanteDao {
	public void insert(Votante es);
	public void insert(VotanteEntity v);
public void update(Votante es);
public void delete(Integer id);
public Votante select(Integer id);
public List<Votante> selectAll();

}
