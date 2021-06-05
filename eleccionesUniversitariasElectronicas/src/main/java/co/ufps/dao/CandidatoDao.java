package co.ufps.dao;

import java.util.List;

import co.ufps.beans.Candidato;
import co.ufps.entities.CandidatoEntity;

public interface CandidatoDao {

	public void insert(Candidato c);
	
	public void insert(CandidatoEntity c);

	public void update(Candidato c);

	public void delete(Integer id);

	public Candidato select(Integer id);

	public List<Candidato> selectAll();
}
