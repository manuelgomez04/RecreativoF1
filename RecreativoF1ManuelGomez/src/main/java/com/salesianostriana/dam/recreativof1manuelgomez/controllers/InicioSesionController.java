package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioSesionController {

	@Autowired

	@GetMapping("/")
	public String showInicio() {

		return "inicioSesion";
	}

	@GetMapping("/logout")
	public String logOut() {
		return "inicioSesion";
	}
}
