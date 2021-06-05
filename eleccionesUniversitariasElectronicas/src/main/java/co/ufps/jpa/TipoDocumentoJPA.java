package co.ufps.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.ufps.beans.TipoDocumento;
import co.ufps.dao.TipoDocumentoDao;
import co.ufps.entities.EleccionEntity;
import co.ufps.entities.TipoDocumentoEntity;
import co.ufps.util.ConexionPostgreSQLJPA;

public class TipoDocumentoJPA implements TipoDocumentoDao{

	private ConexionPostgreSQLJPA conexion;
	
	public TipoDocumentoJPA() {
		this.conexion = conexion.getConexion();
	}
	
	@Override
	public void insert(TipoDocumento e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(TipoDocumentoEntity td) {
		// TODO Auto-generated method stub
		EntityManager em = this.conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(td);
		tx.commit();
	}
	
	@Override
	public void update(TipoDocumento e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoDocumentoEntity select(Integer id) {
		// TODO Auto-generated method stub
		EntityManager em = this.conexion.getEm();
		TipoDocumentoEntity e = em.find(TipoDocumentoEntity.class, id);
		return e;
	}

	@Override
	public List<TipoDocumento> selectAll() {
		EntityManager em = this.conexion.getEm();
		List<TipoDocumentoEntity> tipodocumentos = em.createQuery("from tipodocumento", TipoDocumentoEntity.class).getResultList();
		return selectAll(tipodocumentos);
	}
	
	private List<TipoDocumento> selectAll(List<TipoDocumentoEntity> e)
	{
		List<TipoDocumento> tipodocumentos = new ArrayList<>();
		for(TipoDocumentoEntity el:e)
		{
			int id = el.getId().intValue();
			
			String descripcion= el.getDescripcion();
			TipoDocumento bean = new TipoDocumento(id,descripcion);
			tipodocumentos.add(bean);
		}
		return tipodocumentos;
	}





}
