package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

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

	@OneToMany(mappedBy = "presupuesto", fetch = FetchType.EAGER)
	private List<Carrera> listaCarreras;
}
