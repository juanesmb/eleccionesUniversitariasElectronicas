package co.ufps.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity (name="tipodocumento")
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoEntity {

	@Id
	private Integer id;
	
	@Column (length=50)
	private String descripcion;
	
	@OneToMany(mappedBy="tipodocumento")
	private List<VotanteEntity> votantes;
	
	
	
	public void addVotante(VotanteEntity votante)
	{
		votantes.add(votante);
		votante.setTipodocumento(this);
	}



	public TipoDocumentoEntity(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
}
