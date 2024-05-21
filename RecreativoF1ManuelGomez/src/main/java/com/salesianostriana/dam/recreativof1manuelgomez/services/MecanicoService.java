package com.salesianostriana.dam.recreativof1manuelgomez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Mecanico;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.MecanicoRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class MecanicoService extends BaseServiceImpl<Mecanico, Long, MecanicoRepository> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CarreraService carreraService;

	//Este método me crea un nuevo mecánico y me lo guarda en la BBDD
	public void esMecnaico(Mecanico mecanico) {
		mecanico.setCarreraEmpleado(carreraService.findById(mecanico.getCarreraEmpleado().getId()).get());

		String encodedPassword = passwordEncoder.encode(mecanico.getPassword());
		mecanico.setPassword(encodedPassword);
		mecanico.setAdmin(false);
		mecanico.setMecanico(true);
		mecanico.setPiloto(false);
		this.repository.save(mecanico);
	}

}
