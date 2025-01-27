package com.salesianostriana.dam.recreativof1manuelgomez.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Empleado;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.EmpleadoRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

import jakarta.annotation.PostConstruct;

@Service
public class EmpleadoService extends BaseServiceImpl<Empleado, Long, EmpleadoRepository> {

	
	//Este método me calcula el incentivo de los empleados cuyo coche ha quedao en mejor posición que 10
	@PostConstruct
	public void calcularIncentivoEmpleado() {

		repository.todosMecanicosYPilotosCocheBuenaPosicion().stream().forEach(e -> {
			e.setIncentivoCalculado(e.getSalario() * e.getIncentivo() / 100);
			repository.save(e);
		});

	}

	public boolean buscarUsername(String username) {
		return this.repository.existsByUsername(username);
	}

	public List<Empleado> listaEmpleadosCarrera(Long id) {
		return this.repository.empleadosCarrera(id);
	}

}
