package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class JefeEquipo extends Empleado {

	@ManyToOne
	private List<Componentes> listaComponentes;
}
