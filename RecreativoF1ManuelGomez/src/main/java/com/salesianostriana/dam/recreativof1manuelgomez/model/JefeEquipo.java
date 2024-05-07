package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class JefeEquipo extends Empleado {

	@OneToMany(mappedBy = "jefeComponente",
			fetch = FetchType.EAGER)
	private List<Componente> listaComponentes;

}
