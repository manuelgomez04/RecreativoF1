package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coche {

	@Id
	@GeneratedValue
	private long idCoche;

	private boolean estaDaniado;
	private int posicionCarrera;

	@ManyToOne
	private Carrera carreraCoche;

	@OneToMany(mappedBy = "cocheComponente")
	private List<Componente> listaComponentes;

	@OneToMany(mappedBy = "cocheMecanico")
	private List<Mecanico> listaMecanicos;

	@OneToOne(mappedBy = "cochePiloto")
	private Piloto piloto;
}
