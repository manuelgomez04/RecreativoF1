package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Empleado {

	@Id
	@GeneratedValue
	private long idPiloto;

	private String nombre;
	private String apellidos;
	private String dni;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaNacimiento;

	private double salario;
	private double incentivo;

	@ManyToOne
	private Carrera carrera;

	public void addToCarrera(Carrera carrera) {
		this.carrera = carrera;

		carrera.getListaEmpleados().add(this);

	}

	public void removeToCarrera(Carrera carrera) {
		carrera.getListaEmpleados().remove(this);

		this.carrera = null;
	}

}
