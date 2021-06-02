package co.ufps.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
public class TipoDocumento {
	private Integer id;
	

	private String descripcion;
	
}
