package com.salesianostriana.dam.recreativof1manuelgomez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Presupuesto;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.PresupuestoRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class PresupuestoService extends BaseServiceImpl<Presupuesto, Long, PresupuestoRepository> {

	@Autowired
	private EmpleadoService empleadoService;

	@Transactional
	public void modifyPresupInicial() {

		Presupuesto presupuesto = repository.findById(1L).get();

		presupuesto.setGastosFIjos(empleadoService.findAll().stream().mapToDouble(e -> e.getSalario()).sum());
		repository.save(presupuesto);

	}
}
