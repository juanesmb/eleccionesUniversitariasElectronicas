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
@Entity (name="candidato")
public class CandidatoEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column (length=15)
	private String documento;
	
	@Column (length=50)
	private String nombre;
	
	@Column (length=50)
	private String apellido;
	
	@ManyToOne
	@JoinColumn(name="eleccion")
	private EleccionEntity eleccion;
	
	@Column
	private Integer numero;

	@OneToMany(mappedBy="candidato")
	private List<VotoEntity> votos;
	
	public void addVoto(VotoEntity voto)
	{
		votos.add(voto);
		voto.setCandidato(this);
	}
	
	public CandidatoEntity(String documento, String nombre, String apellido) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
}
