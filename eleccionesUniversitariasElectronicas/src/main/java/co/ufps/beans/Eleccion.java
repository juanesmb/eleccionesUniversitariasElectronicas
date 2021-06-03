package co.ufps.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Eleccion implements Serializable {
	private int id;
	private String nombre;
	private String fechaInicio;
	private String fechaFin;
	private String cargo;
}
