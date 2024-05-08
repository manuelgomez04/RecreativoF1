package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Coche {

	@Id
	@GeneratedValue
	private long idCoche;

	private boolean estaDaniado;
	private int posicionCarrera;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_coche_carrera"))
	private Carrera carreraCoche;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "cocheComponente", fetch = FetchType.EAGER)
	private List<Componente> listaComponentes;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "cocheMecanico", fetch = FetchType.EAGER)
	private List<Mecanico> listaMecanicos;

	@OneToOne(mappedBy = "cochePiloto", fetch = FetchType.EAGER)
	private Piloto piloto;
}
