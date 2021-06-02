package co.ufps.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data

public class Voto {

	private Integer id;
	private Timestamp fechacreacion;
	private Timestamp fechavoto;
	private String uuid;
	private String enlace;
	private Integer estamento;
	private Integer candidato;
	private Integer votante;
}
