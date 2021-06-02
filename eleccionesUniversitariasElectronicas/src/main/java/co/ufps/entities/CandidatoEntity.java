package co.ufps.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity (name="candidato")
public class CandidatoEntity {

	@Id
	private Integer id;
	
	@Column (length=200)
	private String documento;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column (length=50)
	private Integer eleccion;
	
	@Column (length=50)
	private Integer numero;
}
