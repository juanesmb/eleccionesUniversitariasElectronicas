package co.ufps.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionPostgreSQLJPA {
	
	private EntityManager em;
	
	private static ConexionPostgreSQLJPA conexion;
	
	private ConexionPostgreSQLJPA() {
		if(this.em==null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("eleccionesUniversitariasElectronicas");
			this.em = emf.createEntityManager();
		}
	}
	
	public static ConexionPostgreSQLJPA getConexion()
	{
		if(conexion == null) {
			conexion = new ConexionPostgreSQLJPA();
		}
		return conexion;
	}
	
	public EntityManager getEm()
	{
		return this.em;
	}
	
}
