package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@Entity
@ToString

public class JefeEquipo extends Empleado {

	@OneToMany(mappedBy = "jefeComponente")
	private List<Componente> listaComponentes;

}
