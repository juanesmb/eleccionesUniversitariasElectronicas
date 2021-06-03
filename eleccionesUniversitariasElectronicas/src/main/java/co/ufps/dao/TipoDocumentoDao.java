package co.ufps.dao;

import java.util.List;

import co.ufps.beans.TipoDocumento;



public interface TipoDocumentoDao {
	public void insert(TipoDocumento td);
public void update(TipoDocumento es);
public void delete(Integer id);
public TipoDocumento select(Integer id);
public List<TipoDocumento> selectAll();

}
