package com.salesianostriana.dam.recreativof1manuelgomez.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Carrera;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Empleado;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.CarreraRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class CarreraService extends BaseServiceImpl<Carrera, Long, CarreraRepository> {

	@Autowired
	private EmpleadoService empleadoService;

	public Carrera primeraCarrera() {

		return repository.primeraCarrera();
	}

	//Método que llama un listado de los empleados que trabajan en una carrera
	public Map<Long, List<Empleado>> getEmpleadosPorCarrera() {
		List<Carrera> carreras = this.repository.findAll();
		Map<Long, List<Empleado>> empleadosPorCarrera = new HashMap<>();

		for (Carrera carrera : carreras) {
			List<Empleado> empleados = empleadoService.listaEmpleadosCarrera(carrera.getId());
			empleadosPorCarrera.put(carrera.getId(), empleados);
		}

		return empleadosPorCarrera;
	}
}
