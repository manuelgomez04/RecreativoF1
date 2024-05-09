package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.recreativof1manuelgomez.services.PilotoService;

@Controller

public class PilotoController {

	@Autowired
	PilotoService pilotoService;
	
	@GetMapping("/pilotos")
	public String showPiloto(Model model) {
		
		model.addAttribute("listaPilotos", pilotoService.findAll());
		
		return "pilotos";
	}
}
