package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Carrera;
import com.salesianostriana.dam.recreativof1manuelgomez.services.CarreraService;

@Controller

@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;

	@GetMapping("/")
	public String showCarrera(Model model) {

		model.addAttribute("listaCarreras", carreraService.findAll());
		return "carrera";
	}

	@GetMapping("/carreraFormAdd")
	public String addCarrera(Model model) {
		Carrera carrera = new Carrera();

		model.addAttribute("carreraForm", carrera);
		return "carreraForm";

	}

	@PostMapping("/addCarrera")
	public String showCarrera(@ModelAttribute("carreraForm") Carrera carrera, Model model) {

		carreraService.save(carrera);

		return "redirect:/carrera/";

	}
}
