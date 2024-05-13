package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Coche;
import com.salesianostriana.dam.recreativof1manuelgomez.services.CocheService;

@Controller
@RequestMapping("/coche")
public class CocheController {

	@Autowired
	private CocheService cocheService;

	@GetMapping("/editarCoche/{id}")
	public String editCoche(@PathVariable("id") Long id, Model model) {

		if (cocheService.findById(id).isPresent()) {
			model.addAttribute("editarCoche", cocheService.findById(id).get());

			return "editarCoche";
		} else {
			return "coches";
		}
	}

	@PostMapping("/editarCoche/submit")
	public String procesarFormularioEdicion(@ModelAttribute("editarCoche") Coche coche) {

		cocheService.save(coche);
		return "redirect:/main/coches";
	}
}
