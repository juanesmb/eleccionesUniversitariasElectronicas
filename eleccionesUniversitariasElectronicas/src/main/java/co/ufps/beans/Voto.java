package co.ufps.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto implements Serializable {

	private Integer id;
	private String fechacreacion;
	private String fechavoto;
	private String uuid;
	private String enlace;
	private Integer estamento;
	private Integer candidato;
	private Integer votante;
}
