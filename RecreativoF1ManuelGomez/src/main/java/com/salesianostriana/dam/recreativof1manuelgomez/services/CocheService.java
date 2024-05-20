package com.salesianostriana.dam.recreativof1manuelgomez.services;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Coche;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.CocheRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class CocheService extends BaseServiceImpl<Coche, Long, CocheRepository> {

	public void cochesDaniados() {
		for (Coche coche : repository.findAll()) {
			boolean algunComponenteDaniado = coche.getListaComponentes().stream().anyMatch(c -> c.isEstaDaniado());

			coche.setEstaDaniado(algunComponenteDaniado);
			repository.save(coche);
		}
	}

	public boolean verificarSiCochesTienenPiloto() {
		return this.repository.findAll().stream().allMatch(c -> c.getPiloto() != null);
	}
}
