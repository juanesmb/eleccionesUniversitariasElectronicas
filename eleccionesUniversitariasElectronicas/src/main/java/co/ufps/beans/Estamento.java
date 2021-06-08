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
public class Estamento implements Serializable {

	private Integer id;

	private Integer eleccion;

	private String descripcion;

	public Estamento(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
}
