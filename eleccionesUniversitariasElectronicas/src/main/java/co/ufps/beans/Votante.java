package co.ufps.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Votante {

	private Integer id;
	 
	private String nombre;
	
	private String apellido;
	
	private String documento;
	
	private Integer tipodocumento;
	
	private Integer eleccion;
}
