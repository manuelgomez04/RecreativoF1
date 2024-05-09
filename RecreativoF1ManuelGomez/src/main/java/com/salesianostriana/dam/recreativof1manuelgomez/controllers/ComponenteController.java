package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Componente;
import com.salesianostriana.dam.recreativof1manuelgomez.services.CarreraService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.CocheService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.ComponenteService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.JefeEquipoService;

@Controller

@RequestMapping("/componentes")
public class ComponenteController {

	@Autowired
	private ComponenteService componenteService;

	@Autowired
	private CocheService cocheService;

	@Autowired
	private JefeEquipoService jefeEquipoService;

	@Autowired
	private CarreraService carreraService;

	@GetMapping("/")
	public String showComponentes(Model model) {

		model.addAttribute("listaComponentes", componenteService.findAll());

		return "componentes";

	}

	@GetMapping("/componenteFormAdd")
	public String addComponente(Model model) {
		Componente componente = new Componente();

		model.addAttribute("componenteForm", componente);
		model.addAttribute("listaCoches", cocheService.findAll());
		model.addAttribute("jefeEquipo", jefeEquipoService.findAll());
		model.addAttribute("carrera", carreraService.findAll());
		return "componenteForm";
	}

	@PostMapping("/addComponente")
	public String showPiloto(@ModelAttribute("componenteForm") Componente componente, Model model) {
		if (cocheService.findById(componente.getCocheComponente().getIdCoche()).isPresent()
				&& carreraService.findById(componente.getCarreraComponente().getId()).isPresent()
				&& jefeEquipoService.findById(componente.getJefeComponente().getIdEmpleado()).isPresent()) {
			componente.setCocheComponente(cocheService.findById(componente.getCocheComponente().getIdCoche()).get());
			componente.setCarreraComponente(carreraService.findById(componente.getCarreraComponente().getId()).get());
			componente.setJefeComponente(
					jefeEquipoService.findById(componente.getJefeComponente().getIdEmpleado()).get());

			componenteService.save(componente);
		}

		return "redirect:/componentes/";
	}

}
