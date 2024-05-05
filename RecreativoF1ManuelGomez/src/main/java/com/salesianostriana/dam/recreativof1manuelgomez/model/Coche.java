package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

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
public class Coche {

	@Id
	@GeneratedValue
	private long idCoche;

	private boolean estaDaniado;

	private int posicionCarrera;
	private Carrera carrera;

	private List<Componentes> listaComponentes;
	private List<Mecanico> listaMecanicos;
}
