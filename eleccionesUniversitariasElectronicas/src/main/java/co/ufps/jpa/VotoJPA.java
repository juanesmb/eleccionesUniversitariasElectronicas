package co.ufps.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import co.ufps.beans.Voto;
import co.ufps.dao.VotoDao;
import co.ufps.entities.VotoEntity;
import co.ufps.util.ConexionPostgreSQLJPA;

public class VotoJPA implements VotoDao{

	private ConexionPostgreSQLJPA conexion;
	
	public VotoJPA() {
		this.conexion = conexion.getConexion();
	}
	
	@Override
	public void insert(Voto e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void insert(VotoEntity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Voto e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Voto select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto> selectAll() {
		EntityManager em = this.conexion.getEm();
		List<VotoEntity> elecciones = em.createQuery("from voto", VotoEntity.class).getResultList();
		return selectAll(elecciones);
	}
	
	private List<Voto> selectAll(List<VotoEntity> e)
	{
		List<Voto> elecciones = new ArrayList<>();
		for(VotoEntity el:e)
		{
			int id = el.getId().intValue();
			String uuid = el.getUuid();
			String fechaCreacion = el.getFechacreacion().toString();
			String fechaVoto = el.getFechavoto().toString();
			String enlace = el.getEnlace();
			int estamento = el.getEstamento().getId().intValue();
			int candidato = el.getCandidato().getId().intValue();
			int votante = el.getVotante().getId().intValue();
			Voto bean = new Voto(id,uuid,fechaCreacion,fechaVoto,enlace,estamento,candidato,votante);
			elecciones.add(bean);
		}
		return elecciones;
	}

}
