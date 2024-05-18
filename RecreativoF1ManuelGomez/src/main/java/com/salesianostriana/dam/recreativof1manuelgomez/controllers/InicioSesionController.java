package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioSesionController {

//	@Autowired
//	private PresupuestoService presupuestoService;

	@GetMapping("/")
	public String showInicio() {
		// presupuestoService.modifyPresupInicial();

		return "inicioSesion";
	}

	@GetMapping("/logout")
	public String logOut() {
		return "inicioSesion";
	}
}
