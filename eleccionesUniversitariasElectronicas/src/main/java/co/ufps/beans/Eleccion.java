package co.ufps.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Eleccion implements Serializable {
	private int id;
	private String nombre;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private String cargo;
}
