package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Coche {

	@Id
	@GeneratedValue
	private long idCoche;

	private boolean estaDaniado;

	private int posicionCarrera;
	private Carrera carrera;

	@OneToMany(mappedBy = "componentes", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Componentes> listaComponentes;

	@OneToMany(mappedBy = "mecanico",
			fetch = FetchType.EAGER)
	private List<Mecanico> listaMecanicos;

	public void addComponente(Componentes c) {
		c.setCoche(this);
		this.listaComponentes.add(c);
	}

	public void removeComponente(Componentes c) {
		this.listaComponentes.remove(c);
		c.setCoche(null);
	}
}
