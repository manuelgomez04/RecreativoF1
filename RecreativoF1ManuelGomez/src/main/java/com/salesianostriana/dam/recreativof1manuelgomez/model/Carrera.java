package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class Carrera {

	@Id
	@GeneratedValue
	private long id;

	private double longitudPorVuelta;
	private double longitudTotal;
	private String tipoAsfaltado;
	private String nombreCircuito;
	private String localizacion;

	@OneToMany(mappedBy = "carreraEmpleado")
	private List<Empleado> listaEmpleados;

	@OneToMany(mappedBy = "carreraComponente")
	private List<Componente> listaComponentes;

	@OneToMany(mappedBy = "carreraCoche")
	private List<Coche> listaCoches;

}