package co.ufps.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.ufps.beans.Estamento;
import co.ufps.dao.EstamentoDao;
import co.ufps.entities.EleccionEntity;
import co.ufps.entities.EstamentoEntity;
import co.ufps.util.ConexionPostgreSQLJPA;

public class EstamentoJPA implements EstamentoDao{

	private ConexionPostgreSQLJPA conexion;
	
	public EstamentoJPA() {
		this.conexion = conexion.getConexion();
	}
	
	@Override
	public void insert(Estamento e) {
		EstamentoEntity estamento = new EstamentoEntity();
		estamento.setDescripcion(e.getDescripcion());
		
		EleccionJPA eleccionJPA = new EleccionJPA();
		EleccionEntity eleccion = eleccionJPA.select(e.getEleccion());
		
		estamento.setEleccion(eleccion);
		
		this.insert(estamento);
	}
	
	@Override
	public void insert(EstamentoEntity e) {
		EntityManager em = this.conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
	}

	@Override
	public void update(Estamento e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EstamentoEntity select(Integer id) {
		EntityManager em = this.conexion.getEm();
		EstamentoEntity e = em.find(EstamentoEntity.class, id);
		return e;
	}

	@Override
	public List<Estamento> selectAll() {
		EntityManager em = this.conexion.getEm();
		List<EstamentoEntity> elecciones = em.createQuery("from estamento", EstamentoEntity.class).getResultList();
		return selectAll(elecciones);
	}
	
	private List<Estamento> selectAll(List<EstamentoEntity> e)
	{
		List<Estamento> elecciones = new ArrayList<>();
		for(EstamentoEntity el:e)
		{
			int id = el.getId().intValue();
			int eleccion = el.getEleccion().getId();
			String descripcion = el.getDescripcion();

			Estamento bean = new Estamento(id,eleccion,descripcion);
			elecciones.add(bean);
		}
		return elecciones;
	}
	
	public List<Estamento> selectEleccion(int i) {
		EntityManager em = this.conexion.getEm();
		List<EstamentoEntity> estamentos = em.createQuery("from estamento", EstamentoEntity.class).getResultList();
		return selectEleccion(estamentos,i);
	}
	
	private List<Estamento> selectEleccion(List<EstamentoEntity> e, int i)
	{
		List<Estamento> estamentos = new ArrayList<>();
		for(EstamentoEntity el:e){
			
		if(el.getEleccion().getId()==i) {
			int id = el.getId().intValue();
			int eleccion = el.getEleccion().getId();
			String descripcion = el.getDescripcion();

			Estamento bean = new Estamento(id,eleccion,descripcion);
			estamentos.add(bean);
		}
		
		}
		return estamentos;
	}
}
