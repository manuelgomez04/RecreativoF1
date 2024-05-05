package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Carrera {

	@Id
	@GeneratedValue
	private long idCarrera;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaCarrera;

	private double longitudPorVuelta;
	private double longitudTotal;
	private boolean asfaltado;
	private String nombreCircuito;
	private String localizacion;

	private List<Empleado> listaEmpleados;
	private List<Componentes> listaComponentes;
}
