package com.salesianostriana.dam.recreativof1manuelgomez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Piloto;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.PilotoRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class PilotoService extends BaseServiceImpl<Piloto, Long, PilotoRepository> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CocheService cocheService;

	public void esPiloto(Piloto piloto) {
		piloto.setCochePiloto(cocheService.findById(piloto.getCochePiloto().getIdCoche()).get());
		String encodedPassword = passwordEncoder.encode(piloto.getPassword());
		piloto.setPassword(encodedPassword);
		piloto.setAdmin(false);
		piloto.setMecanico(false);
		piloto.setPiloto(true);
		this.repository.save(piloto);
	}
}
