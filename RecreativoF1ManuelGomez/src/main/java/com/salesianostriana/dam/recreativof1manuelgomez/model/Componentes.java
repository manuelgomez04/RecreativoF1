package com.salesianostriana.dam.recreativof1manuelgomez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Componentes {

	@Id
	@GeneratedValue
	private long idComponente;
	private String tipoComponente;
	private double durabilidad;
	private double precio;
	private String marca;
	private Carrera carrera;
}
