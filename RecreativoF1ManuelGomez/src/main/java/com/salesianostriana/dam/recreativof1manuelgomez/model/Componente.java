package com.salesianostriana.dam.recreativof1manuelgomez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Componente {

	@Id
	@GeneratedValue
	private long idComponente;

	private String tipoComponente;
	private double durabilidad;
	private double precio;
	private String marca;

	@ManyToOne
	private Coche cocheComponente;

	@ManyToOne
	private JefeEquipo jefeComponente;

	@ManyToOne
	private Carrera carreraComponente;
}
