package co.ufps.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Candidato implements Serializable {

	private Integer id;

	private String documento;

	private String nombre;

	private String apellido;

	private Integer eleccion;

	private Integer numero;
	
	public Candidato(String documento, String nombre, String apellido)
	{
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Candidato(String documento, String nombre, String apellido, Integer eleccion)
	{
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eleccion = eleccion;
	}

	public Candidato(Integer id, String documento, String nombre, String apellido, Integer numero) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero = numero;
	}
	
	
}
