package com.salesianostriana.dam.recreativof1manuelgomez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Presupuesto;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.PresupuestoRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class PresupuestoService extends BaseServiceImpl<Presupuesto, Long, PresupuestoRepository> {

	@Autowired
	private EmpleadoService empleadoService;

	public void modifyPresupInicial() {
		Presupuesto presupuesto = repository.findById(1L).get();
		presupuesto.setGastosFijos(
				empleadoService.findAll().stream().mapToDouble(empleado -> empleado.getSalario()).sum());
		repository.save(presupuesto);
	}

	public double calcularResultado() {
		Presupuesto presupuesto = repository.findById(1L).get();

		Double presupuestoFinal = 0.0;

		presupuestoFinal = presupuesto.getPresupuestoInicial() - presupuesto.getGastosFijos()
				- presupuesto.getGastosVariables() + presupuesto.getIngresosFijos() + presupuesto.getGastosVariables();

		return presupuestoFinal;
	}
}
