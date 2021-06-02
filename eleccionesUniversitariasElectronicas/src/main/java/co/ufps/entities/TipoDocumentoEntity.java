package co.ufps.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity (name="tipodocumento")
public class TipoDocumentoEntity {

	@Id
	private Integer id;
	
	@Column (length=50)
	private String descripcion;
	
}
