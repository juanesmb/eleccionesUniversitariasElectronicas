package co.ufps.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.ufps.beans.Candidato;
import co.ufps.beans.Votante;
import co.ufps.dao.VotanteDao;
import co.ufps.entities.CandidatoEntity;
import co.ufps.entities.VotanteEntity;
import co.ufps.util.ConexionPostgreSQLJPA;

public class VotanteJPA implements VotanteDao{

	private ConexionPostgreSQLJPA conexion;
	
	public VotanteJPA() {
		this.conexion = conexion.getConexion();
	}
	
	@Override
	public void insert(Votante c) {
		VotanteEntity votante = new VotanteEntity();
		votante.setDocumento(c.getDocumento());
		votante.setNombre(c.getNombre());
		votante.setEmail(c.getEmail());
		this.insert(votante);
	}
	
	public void insert(VotanteEntity c) {
		EntityManager em = this.conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}


	@Override
	public void update(Votante e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Votante select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Votante> selectAll() {
		EntityManager em = this.conexion.getEm();
		List<VotanteEntity> elecciones = em.createQuery("from votante", VotanteEntity.class).getResultList();
		return selectAll(elecciones);
	}
	
	private List<Votante> selectAll(List<VotanteEntity> e)
	{
		List<Votante> elecciones = new ArrayList<>();
		for(VotanteEntity el:e)
		{
			int id = el.getId().intValue();
			String nombre = el.getNombre();
			String email = el.getEmail();
			String documento = el.getDocumento();
			int tipodocumento = el.getTipodocumento().getId();
			int eleccion = el.getEleccion().getId();
			Votante bean = new Votante(id,nombre,email,documento,tipodocumento,eleccion);
			elecciones.add(bean);
		}
		return elecciones;
	}

}
