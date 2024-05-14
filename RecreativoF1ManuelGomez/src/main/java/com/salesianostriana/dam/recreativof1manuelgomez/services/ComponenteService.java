package com.salesianostriana.dam.recreativof1manuelgomez.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Componente;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.ComponenteRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class ComponenteService extends BaseServiceImpl<Componente, Long, ComponenteRepository> {

	public List<Componente> mostrarComponentesSinCoche() {

		return repository.findComponenteSinCoche();
	}
}
