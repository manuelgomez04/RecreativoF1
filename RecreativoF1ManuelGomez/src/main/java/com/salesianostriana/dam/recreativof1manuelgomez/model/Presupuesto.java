package com.salesianostriana.dam.recreativof1manuelgomez.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Presupuesto {

	private double presupuestoInicial;
	private double ingresosFijos;
	private double gastosFijos;
	private double ingresosVariables;
	private double gastosVariables;
}
