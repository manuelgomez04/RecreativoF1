package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarreraController {

	@GetMapping("/carrera")
	public String showCarrera() {
		return "carrera";
	}
}
