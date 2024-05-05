package com.salesianostriana.dam.recreativof1manuelgomez.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Piloto extends Empleado {

	private Coche coche;

	private int posicionCarrera;
}
