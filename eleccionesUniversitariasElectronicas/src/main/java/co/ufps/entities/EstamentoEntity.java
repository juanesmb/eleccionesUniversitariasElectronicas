package co.ufps.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity (name="estamento")
public class EstamentoEntity {

	@Id
	private Integer id;
	
	@Column (length=200)
	private Integer eleccion;
	
	@Column
	private String descripcion;

}
