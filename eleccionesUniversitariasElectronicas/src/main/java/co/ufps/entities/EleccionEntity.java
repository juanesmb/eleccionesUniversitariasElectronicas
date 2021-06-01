package co.ufps.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity (name="eleccion")
public class EleccionEntity {

	@Id
	private Integer id;
	
	@Column (length=200)
	private String nombre;
	
	@Column
	private Timestamp fechaInicio;
	
	@Column
	private Timestamp fechaFin;
	
	@Column (length=50)
	private String cargo;
}
