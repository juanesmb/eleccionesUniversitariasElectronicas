package co.ufps.dao;

import java.util.List;

import javax.persistence.OneToMany;

import co.ufps.beans.Candidato;
import co.ufps.entities.CandidatoEntity;
import co.ufps.entities.EleccionEntity;
import co.ufps.entities.VotoEntity;

public interface CandidatoDao {

	public void insert(Candidato c);
	
	public void insert(CandidatoEntity c);

	public void update(Candidato c);

	public void delete(Integer id);

	public CandidatoEntity select(Integer id);

	public List<Candidato> selectAll();
	
	
}
