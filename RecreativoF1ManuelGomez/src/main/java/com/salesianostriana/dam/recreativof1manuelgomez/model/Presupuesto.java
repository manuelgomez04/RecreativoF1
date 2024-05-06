package com.salesianostriana.dam.recreativof1manuelgomez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Presupuesto {

	@Id
	@GeneratedValue
	private long idPresupuesto;
	private double ingresosFijos;
	private double gastosFIjos;
	private double ingresosVariables;
	private double gastosvariables;
}
