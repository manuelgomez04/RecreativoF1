package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PilotoController {

	@GetMapping("/pilotos")
	public String showPiloto() {
		return "pilotos";
	}
}