package co.ufps.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.ufps.beans.Eleccion;
import co.ufps.dao.EleccionDao;
import co.ufps.entities.EleccionEntity;
import co.ufps.util.ConexionPostgreSQLJPA;

public class EleccionJPA implements EleccionDao{

	private ConexionPostgreSQLJPA conexion;
	
	public EleccionJPA() {
		this.conexion = conexion.getConexion();
	}
	
	@Override
	public void insert(Eleccion e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void insert(EleccionEntity e) {
		EntityManager em = this.conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
	}

	@Override
	public void update(Eleccion e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EleccionEntity select(Integer id) {
		EntityManager em = this.conexion.getEm();
		EleccionEntity e = em.find(EleccionEntity.class, id);
		return e;
	}

	@Override
	public List<Eleccion> selectAll() {
		EntityManager em = this.conexion.getEm();
		List<EleccionEntity> elecciones = em.createQuery("from eleccion", EleccionEntity.class).getResultList();
		return selectAll(elecciones);
	}
	
	private List<Eleccion> selectAll(List<EleccionEntity> e)
	{
		List<Eleccion> elecciones = new ArrayList<>();
		for(EleccionEntity el:e)
		{
			int id = el.getId().intValue();
			String nombre = el.getNombre();
			String fechaInicio = el.getFechaInicio().toString();
			String fechaFin = el.getFechaFin().toString();
			String cargo = el.getCargo();
			Eleccion bean = new Eleccion(id,nombre,fechaInicio,fechaFin,cargo);
			elecciones.add(bean);
		}
		return elecciones;
	}

}
