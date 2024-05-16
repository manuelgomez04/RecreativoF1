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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	private double presupuestoInicial;
	private double gastosFijos;
	private double ingresosVariables;
	private double gastosVariables;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "presupuesto", fetch = FetchType.EAGER)
	private List<Carrera> listaCarreras;

}
