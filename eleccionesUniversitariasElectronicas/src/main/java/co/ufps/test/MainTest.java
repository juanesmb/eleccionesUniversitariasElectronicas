package co.ufps.test;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import co.ufps.beans.Eleccion;
import co.ufps.entities.EleccionEntity;
import co.ufps.util.ConexionPostgreSQLJPA;

public class MainTest {

	public static void main(String [] args)
	{
		EntityManager em = ConexionPostgreSQLJPA.getConexion().getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		insertarElecciones(em);
		
		tx.commit();
		em.close();
	}

	private static void insertarElecciones(EntityManager em) {
		
		em.persist(new EleccionEntity("elecciones presidencia estudiantil",Timestamp.valueOf("2021-12-11 08:00:00"),Timestamp.valueOf("2021-12-12 08:00:00"),"presidencia estudiantil"));
		em.persist(new EleccionEntity("elecciones consejo superior",Timestamp.valueOf("2022-03-10 10:00:00"),Timestamp.valueOf("2022-03-12 10:00:00"),"consejo superior"));
	}

	private static void consultarElecciones(EntityManager em) {
		List<EleccionEntity> elecciones = em.createQuery("from eleccion", EleccionEntity.class).getResultList();
		for(EleccionEntity e: elecciones)
		{
			System.out.println("id: " + e.getId());
			System.out.println("nombre: " + e.getNombre());
			System.out.println("Fecha inicio: " + e.getFechaInicio().toString());
			System.out.println("Fecha fin: " + e.getFechaFin().toString());
			System.out.println("cargo: " + e.getCargo());
		}
	}
}
