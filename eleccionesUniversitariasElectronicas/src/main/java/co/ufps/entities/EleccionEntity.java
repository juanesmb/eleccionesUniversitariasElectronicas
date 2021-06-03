package co.ufps.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity (name="eleccion")
public class EleccionEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column (length=200)
	private String nombre;
	
	@Column
	private Timestamp fechaInicio;
	
	@Column
	private Timestamp fechaFin;
	
	@Column (length=50)
	private String cargo;
	
	@OneToMany(mappedBy="eleccion")
	private List<CandidatoEntity> candidatos;

	public EleccionEntity()
	{
		
	}
	
	public EleccionEntity(String nombre, Timestamp fechaInicio, Timestamp fechaFin, String cargo) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
	}
	
	
}
