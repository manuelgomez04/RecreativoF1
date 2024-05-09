package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Carrera;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Coche;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Componente;
import com.salesianostriana.dam.recreativof1manuelgomez.model.JefeEquipo;
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

	@GetMapping("/edit/{id}")
	public String editarComponente(@PathVariable("id") Long id, Model model) {

		if (componenteService.findById(id).isPresent()) {
			model.addAttribute("componenteForm", componenteService.findById(id).get());
			List<Coche> listaCochesOpcion = cocheService.findAll();
			List<Carrera> listaCarrerasOpcion = carreraService.findAll();
			List<JefeEquipo> listaJefeEquipoOpcion = jefeEquipoService.findAll();

			model.addAttribute("listaCoches", listaCochesOpcion);
			model.addAttribute("carrera", listaCarrerasOpcion);
			model.addAttribute("jefeEquipo", listaJefeEquipoOpcion);

			return "componenteForm";
		} else {
			return "componentes";
		}

	}

	@PostMapping("editarComponente/submit")
	public String procesarEditarComponente(@ModelAttribute("componenteForm") Componente componente) {
		componenteService.save(componente);
		return "redirect:/componentes/";
	}

}
