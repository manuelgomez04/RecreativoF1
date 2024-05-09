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

import com.salesianostriana.dam.recreativof1manuelgomez.model.Coche;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Mecanico;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Piloto;
import com.salesianostriana.dam.recreativof1manuelgomez.services.CocheService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.PilotoService;

@Controller

@RequestMapping("/pilotos")
public class PilotoController {

	@Autowired
	PilotoService pilotoService;
	
	@Autowired
	private CocheService cocheService;
	
	@GetMapping("/")
	public String showPiloto(Model model) {
		
		model.addAttribute("listaPilotos", pilotoService.findAll());
		
		return "pilotos";
	}
	
	@GetMapping ("/add")
	public String addPiloto ( Model model) {
		Piloto piloto = new Piloto();
		
		model.addAttribute("pilotoForm", piloto);
		model.addAttribute("listaCoches",cocheService.findAll());
		return "pilotoForm";
	}
	
	@PostMapping("/addPiloto")
	public String showPiloto(@ModelAttribute("pilotoForm") Piloto piloto, Model model) {
		if (cocheService.findById(piloto.getIdEmpleado()).isPresent()) {
			piloto.setCochePiloto(cocheService.findById(piloto.getIdEmpleado()).get());
			pilotoService.save(piloto);
		}
		return "redirect:/pilotos/";
	}
	
	@GetMapping("/editar/{id}")
	public String editPiloto(@PathVariable("id") Long id, Model model) {

		if (pilotoService.findById(id).isPresent()) {
			model.addAttribute("pilotoForm", pilotoService.findById(id).get());
			List<Coche> listaCochesOpcion = cocheService.findAll();
			model.addAttribute("listaCoches", listaCochesOpcion);

			return "pilotoForm";
		} else {
			return "pilotos";
		}
	}

	@PostMapping("/editarPiloto/submit")
	public String procesarFormularioEdicionPiloto(@ModelAttribute("pilotoForm") Piloto piloto) {
		pilotoService.save(piloto);
		return "redirect:/pilotos/";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarPiloto (@PathVariable("id") Long id) {
		pilotoService.deleteById(id);
		return "redirect:/pilotos/";
	}
}
