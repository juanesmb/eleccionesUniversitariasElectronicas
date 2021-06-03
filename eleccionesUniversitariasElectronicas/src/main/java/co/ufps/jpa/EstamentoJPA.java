package co.ufps.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import co.ufps.beans.Estamento;
import co.ufps.dao.EstamentoDao;
import co.ufps.entities.EstamentoEntity;
import co.ufps.util.ConexionPostgreSQLJPA;

public class EstamentoJPA implements EstamentoDao{

	private ConexionPostgreSQLJPA conexion;
	
	public EstamentoJPA() {
		this.conexion = conexion.getConexion();
	}
	
	@Override
	public void insert(Estamento e) {
		// TODO Auto-generated method stub
		
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
	public Estamento select(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
			int eleccion = el.getEleccion();
			String descripcion = el.getDescripcion();

			Estamento bean = new Estamento(id,eleccion,descripcion);
			elecciones.add(bean);
		}
		return elecciones;
	}

}
