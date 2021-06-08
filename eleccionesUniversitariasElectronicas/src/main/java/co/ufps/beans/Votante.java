package co.ufps.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Votante implements Serializable {

	private Integer id;
	 
	private String nombre;
	
	private String email;
	
	private String documento;
	
	private Integer tipodocumento;
	
	private Integer eleccion;
	
	public Votante(Integer id,String nombre,String email)
	{
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
}
