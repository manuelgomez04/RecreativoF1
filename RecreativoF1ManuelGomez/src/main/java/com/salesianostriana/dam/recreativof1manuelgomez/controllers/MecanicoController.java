package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Coche;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Empleado;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Mecanico;
import com.salesianostriana.dam.recreativof1manuelgomez.services.CocheService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.MecanicoService;

@Controller
public class MecanicoController {

	@Autowired
	private MecanicoService mecanicoService;

	@Autowired
	private CocheService cocheService;

	@GetMapping("/mecanicos")
	public String mostrarListaMecanicos(Model model) {
		model.addAttribute("listaCompletaMecanicos", mecanicoService.findAll());
		return "mecanicos";
	}

	@GetMapping("/mecanicoFormAdd")
	public String adddMecanico(Model model) {
		Empleado mecanico = new Mecanico();
		model.addAttribute("mecanicoForm", mecanico);
		model.addAttribute("listaCoches", cocheService.findAll());
		return "mecanicoForm";
	}

	@PostMapping("/addMecanico")
	public String showMecanico(@ModelAttribute("mecanicoForm") Mecanico mecanico, Model model) {

		Optional<Coche> optionalCoche = cocheService.findById(mecanico.getCocheMecanico().getIdCoche());

		if (optionalCoche.isPresent()) {
			mecanico.setCocheMecanico(optionalCoche.get());

			mecanicoService.save(mecanico);
		}

		return "redirect:/mecanicos";
	}

	@GetMapping("/editar/{id}")
	public String editMecanico(@PathVariable("id") Long id, Model model) {

		if (mecanicoService.findById(id).isPresent()) {
			model.addAttribute("mecanicoForm", mecanicoService.findById(id).get());
			List<Coche> listaCochesOpcion = cocheService.findAll();
			model.addAttribute("listaCoches", listaCochesOpcion);

			return "mecanicoForm";
		} else {
			return "mecanicos";
		}
	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("mecanicoForm") Mecanico m) {
		mecanicoService.save(m);
		return "redirect:/mecanicos";
	}

	@GetMapping("/borrar/{id}")
	public String borrarMecanico(@PathVariable("id") Long id) {
		mecanicoService.deleteById(id);
		return "redirect:/mecanicos";
	}

}
