package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.recreativof1manuelgomez.services.CarreraService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.CocheService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.ComponenteService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.EmpleadoService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.MecanicoService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.PilotoService;

@Controller
@RequestMapping ("/main")
public class MainController {

	@Autowired 
	CocheService cocheService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	CarreraService carreraService;
	
	@Autowired
	PilotoService pilotoService;
	
	@Autowired
	MecanicoService mecanicoService;
	
	@Autowired
	ComponenteService componenteService;
	
	@GetMapping("/pilotos")
	public String showPiloto(Model model) {

		model.addAttribute("listaPilotos", pilotoService.findAll());

		return "pilotos";
	}
	
	@GetMapping("/mecanicos")
	public String mostrarListaMecanicos(Model model) {
		model.addAttribute("listaCompletaMecanicos", mecanicoService.findAll());
		return "mecanicos";
	}
	
	@GetMapping("/coches")
	public String showCoches(Model model) {

		model.addAttribute("listaCoches", cocheService.findAll());
		return "coches";
	}

	@GetMapping("/carrera")
	public String showCarrera(Model model) {

		model.addAttribute("listaCarreras", carreraService.findAll());
		return "carrera";
	}
	
}
