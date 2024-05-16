package com.salesianostriana.dam.recreativof1manuelgomez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Componente;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Presupuesto;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.ComponenteRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class ComponenteService extends BaseServiceImpl<Componente, Long, ComponenteRepository> {

	@Autowired
	PresupuestoService presupuestoService;

	public List<Componente> mostrarComponentesSinCoche() {

		return repository.findComponenteSinCoche();
	}

	public List<Componente> mostrarComponentesConCoche() {
		return repository.findComponenteConCoche();
	}

	public void sumarPrecioAGastos(Long id) {

		Presupuesto presupuesto = presupuestoService.findById(1L).get();
		presupuesto.setGastosVariables(presupuesto.getGastosVariables() + findById(id).get().getPrecio());

		presupuestoService.save(presupuesto);

	}

	public List<Componente> componentesCoche1() {
		return repository.componentesCoche1();
	}

	public List<Componente> componentesCoche2() {
		return repository.componentesCoche2();
	}

	public Componente componenteComprado(Long id) {
		Componente componente;

		componente = Componente.builder().carreraComponente(findById(id).get().getCarreraComponente())
				.durabilidad(findById(id).get().getDurabilidad()).estaDaniado(findById(id).get().isEstaDaniado())
				.jefeComponente(findById(id).get().getJefeComponente()).precio(findById(id).get().getPrecio())
				.marca(findById(id).get().getMarca()).tipoComponente(findById(id).get().getTipoComponente()).build();
		save(componente);

		return componente;
	}
}
