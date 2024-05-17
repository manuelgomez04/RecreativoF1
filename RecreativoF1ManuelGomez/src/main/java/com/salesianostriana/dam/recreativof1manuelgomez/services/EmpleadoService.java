package com.salesianostriana.dam.recreativof1manuelgomez.services;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Empleado;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.EmpleadoRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class EmpleadoService extends BaseServiceImpl<Empleado, Long, EmpleadoRepository> {

	public void calcularIncentivoEmpleado() {

		repository.todosMecanicosYPilotosCocheBuenaPosicion()
		.stream()
		.forEach(e -> {
			e.setIncentivoCalculado(e.getSalario() * e.getIncentivo() / 100);
			repository.save(e);
		});

	}
}
