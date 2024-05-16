package com.salesianostriana.dam.recreativof1manuelgomez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private boolean estaDaniado;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_componente_coche"))
	private Coche cocheComponente;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_componente_jefeEquipo"))
	private JefeEquipo jefeComponente;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_componente_carrera"))
	private Carrera carreraComponente;
	
	public void addToCoche(Coche coche) {
		this.cocheComponente = coche;
		coche.getListaComponentes().add(this);
	}
	
	public void removeFromCoche(Coche coche) {

		coche.getListaComponentes().remove(this);
		
		this.cocheComponente=null;
	}
	
	public void addToJefe(JefeEquipo jefeEquipo) {
		this.jefeComponente = jefeEquipo;
		jefeEquipo.getListaComponentes().add(this);
	}
	
	public void removeFromJefe(JefeEquipo jefeEquipo) {

		jefeEquipo.getListaComponentes().remove(this);
		
		this.jefeComponente=null;
	}
	
	public void addToCarrera(Carrera carrera) {
		this.carreraComponente = carrera;
		carrera.getListaComponentes().add(this);
	}
	
	public void removeFromCarrera (Carrera carrera) {
		carrera.getListaComponentes().remove(this);
		
		this.carreraComponente=null;
	}
}
