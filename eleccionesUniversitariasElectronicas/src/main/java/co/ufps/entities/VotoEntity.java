package co.ufps.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity (name="voto")
public class VotoEntity {

	@Id
	private Integer id;
	
	@Column
	private Timestamp fechacreacion;
	
	@Column
	private Timestamp fechavoto;
	
	@Column (length=50)
	private String uuid;
	
	@Column (length=50)
	private String enlace;
	
	@Column
	private Integer estamento;
	
	@Column
	private Integer candidato;
	
	@Column
	private Integer votante;
}
