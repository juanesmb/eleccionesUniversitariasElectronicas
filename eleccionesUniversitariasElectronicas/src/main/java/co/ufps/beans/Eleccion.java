package co.ufps.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eleccion implements Serializable {
	private int id;
	private String nombre;
	private String fechaInicio;
	private String fechaFin;
	private String cargo;
	
	public Eleccion(String cargo, String fechaInicio, String fechaFin) {
		this.cargo = cargo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
}
