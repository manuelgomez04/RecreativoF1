package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

	@OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
	private List<Empleado> listaEmpleados;

	@ManyToOne
	private List<Componentes> listaComponentes;
}
