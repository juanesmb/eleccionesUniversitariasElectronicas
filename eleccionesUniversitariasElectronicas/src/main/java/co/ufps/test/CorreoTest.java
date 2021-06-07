package co.ufps.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.ufps.util.ConexionPostgreSQLJPA;
import co.ufps.util.ServicioEmail;

public class CorreoTest {
	public static void main(String[] args) {    
	     ServicioEmail email = new ServicioEmail("ejemplo.email.ufps@gmail.com", "nfrbdxklxggkgoko");
	     email.enviarEmail("juanpablocq@ufps.edu.co", "PRUEBA2", "sape");
	 }    
}
