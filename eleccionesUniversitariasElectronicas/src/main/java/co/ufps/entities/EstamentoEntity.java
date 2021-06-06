package co.ufps.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="estamento")
public class EstamentoEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="eleccion")
	private EleccionEntity eleccion;
	
	@Column
	private String descripcion;
	
	@OneToMany(mappedBy="estamento")
	private List<VotoEntity> votos;
	
	public void addVoto(VotoEntity voto)
	{
		votos.add(voto);
		voto.setEstamento(this);
	}

	public EstamentoEntity(EleccionEntity eleccion, String descripcion, List<VotoEntity> votos) {
		this.eleccion = eleccion;
		this.descripcion = descripcion;
		this.votos = votos;
	}

}
