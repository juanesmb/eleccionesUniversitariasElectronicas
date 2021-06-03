package co.ufps.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import co.ufps.beans.TipoDocumento;
import co.ufps.dao.TipoDocumentoDao;
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
	public void update(TipoDocumento e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoDocumento select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoDocumento> selectAll() {
		EntityManager em = this.conexion.getEm();
		List<TipoDocumentoEntity> elecciones = em.createQuery("from tipodocumento", TipoDocumentoEntity.class).getResultList();
		return selectAll(elecciones);
	}
	
	private List<TipoDocumento> selectAll(List<TipoDocumentoEntity> e)
	{
		List<TipoDocumento> elecciones = new ArrayList<>();
		for(TipoDocumentoEntity el:e)
		{
			int id = el.getId().intValue();
			
			String descripcion= el.getDescripcion();
			TipoDocumento bean = new TipoDocumento(id,descripcion);
			elecciones.add(bean);
		}
		return elecciones;
	}

}
