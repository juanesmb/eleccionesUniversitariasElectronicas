package co.ufps.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	@ManyToOne
	@JoinColumn(name="estamento")
	private EstamentoEntity estamento;
	@ManyToOne
	@JoinColumn(name="candidato")
	private CandidatoEntity candidato;
	
	@ManyToOne
	@JoinColumn(name="votante")
	private VotanteEntity votante;

	public VotoEntity(Timestamp fechacreacion, Timestamp fechavoto, String uuid, String enlace) {
		super();
		this.fechacreacion = fechacreacion;
		this.fechavoto = fechavoto;
		this.uuid = uuid;
		this.enlace = enlace;
	}
	
	
}
