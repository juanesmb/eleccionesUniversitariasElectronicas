package co.ufps.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Estamento {

	private Integer id;

	private Integer eleccion;

	private String descripcion;

}
