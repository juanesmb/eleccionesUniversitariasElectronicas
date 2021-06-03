package co.ufps.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity (name="votante")
public class VotanteEntity {

	@Id
	private Integer id;
	 
	@Column (length=100)
	private String nombre;
	
	@Column (length=50)
	private String email;
	
	@Column (length=20)
	private String documento;
	
	@Column 
	private Integer tipodocumento;
	
	@Column 
	private Integer eleccion;
}
