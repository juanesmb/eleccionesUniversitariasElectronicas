package co.ufps.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import co.ufps.beans.Eleccion;
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
	public void update(Eleccion e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Eleccion select(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
