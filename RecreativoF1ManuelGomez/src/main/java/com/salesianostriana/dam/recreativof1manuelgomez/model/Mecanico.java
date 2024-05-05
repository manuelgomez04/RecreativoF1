package com.salesianostriana.dam.recreativof1manuelgomez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Mecanico extends Empleado {

	@ManyToOne
	private Coche coche;

	public void addToCoche(Coche coche) {
		this.coche = coche;
		coche.getListaMecanicos().add(this);
	}

	public void removeCoche(Coche coche) {
		coche.getListaMecanicos().remove(this);
		this.coche = null;
	}
}
