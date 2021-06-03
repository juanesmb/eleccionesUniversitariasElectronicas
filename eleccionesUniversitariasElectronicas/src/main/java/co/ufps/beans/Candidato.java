package co.ufps.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;

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
}
