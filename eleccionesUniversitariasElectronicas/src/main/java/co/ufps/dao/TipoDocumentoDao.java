package co.ufps.dao;

import java.util.List;

import co.ufps.beans.TipoDocumento;
import co.ufps.entities.TipoDocumentoEntity;

public interface TipoDocumentoDao {
	
	public void insert(TipoDocumento td);
	public void insert(TipoDocumentoEntity td);
	public void update(TipoDocumento es);
	public void delete(Integer id);
	public TipoDocumentoEntity select(Integer id);
	public List<TipoDocumento> selectAll();

}
