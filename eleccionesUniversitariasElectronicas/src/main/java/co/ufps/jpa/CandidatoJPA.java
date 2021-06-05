package co.ufps.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.ufps.beans.Candidato;
import co.ufps.dao.CandidatoDao;
import co.ufps.entities.CandidatoEntity;
import co.ufps.util.ConexionPostgreSQLJPA;

public class CandidatoJPA implements CandidatoDao{

	private ConexionPostgreSQLJPA conexion;
	
	public CandidatoJPA() {
		this.conexion = conexion.getConexion();
	}
	
	@Override
	public void insert(Candidato c) {
		CandidatoEntity candidato = new CandidatoEntity();
		candidato.setDocumento(c.getDocumento());
		candidato.setNombre(c.getNombre());
		candidato.setApellido(c.getApellido());
		this.insert(candidato);
	}
	
	public void insert(CandidatoEntity c) {
		EntityManager em = this.conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	@Override
	public void update(Candidato c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Candidato select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidato> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
