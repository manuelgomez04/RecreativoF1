package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComponenteController {

	@GetMapping("/repuestos")
	public String showRepuestos() {
		return "repuestos";
	}
}
