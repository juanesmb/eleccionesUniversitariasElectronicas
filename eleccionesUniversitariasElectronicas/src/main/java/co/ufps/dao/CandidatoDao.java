package co.ufps.dao;

import java.util.List;

import co.ufps.beans.Candidato;

public interface CandidatoDao {

	public void insert(Candidato c);

	public void update(Candidato c);

	public void delete(Integer id);

	public Candidato select(Integer id);

	public List<Candidato> selectAll();
}
