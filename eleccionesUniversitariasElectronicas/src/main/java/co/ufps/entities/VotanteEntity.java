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
@Entity (name="votante")
public class VotanteEntity {

	@Id
	@GeneratedValue
	private Integer id;
	 
	@Column (length=100)
	private String nombre;
	
	@Column (length=50)
	private String email;
	
	@Column (length=20)
	private String documento;
	
	@ManyToOne
	@JoinColumn(name="tipodocumento")
	private   TipoDocumentoEntity tipodocumento;
	
	@ManyToOne
	@JoinColumn     (name="eleccion")
	private EleccionEntity eleccion;
	
	@OneToMany(mappedBy="votante")
	private List<VotoEntity> votos;
	
	public void addVoto(VotoEntity voto)
	{
		votos.add(voto);
		voto.setVotante(this);
	}
	
	public VotanteEntity(String nombre, String email, String documento) {
		this.nombre = nombre;
		this.email = email;
		this.documento = documento;
	}
	
	
	
}
