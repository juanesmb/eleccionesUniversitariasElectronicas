package co.ufps.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.ufps.beans.Candidato;
import co.ufps.beans.Eleccion;
import co.ufps.dao.CandidatoDao;
import co.ufps.entities.CandidatoEntity;
import co.ufps.entities.EleccionEntity;
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
		
		EleccionJPA eleccionJPA = new EleccionJPA();
		EleccionEntity eleccion = eleccionJPA.select(c.getEleccion());
		
		candidato.setEleccion(eleccion);
		
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
	public CandidatoEntity select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Candidato> selectAll() {
		EntityManager em = this.conexion.getEm();
		List<CandidatoEntity> candidatos = em.createQuery("from candidato", CandidatoEntity.class).getResultList();
		return selectAll(candidatos);
	}

	public List<Candidato> selectAll(List<CandidatoEntity> c) {
		List<Candidato> candidatos = new ArrayList<>();
		for(CandidatoEntity can:c)
		{
			Integer id = can.getId();
			String documento = can.getDocumento();
			String nombre = can.getNombre();
			String apellido = can.getApellido();
			Integer numero = can.getNumero();
			Candidato bean = new Candidato(id,documento,nombre,apellido,numero);
			candidatos.add(bean);
		}
		return candidatos;
	}

}
