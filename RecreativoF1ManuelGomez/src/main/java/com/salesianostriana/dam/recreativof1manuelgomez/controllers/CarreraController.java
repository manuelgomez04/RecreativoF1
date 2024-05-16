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
import com.salesianostriana.dam.recreativof1manuelgomez.model.Presupuesto;
import com.salesianostriana.dam.recreativof1manuelgomez.services.CarreraService;
import com.salesianostriana.dam.recreativof1manuelgomez.services.PresupuestoService;

@Controller

@RequestMapping("/admin/carrera")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;

	@Autowired
	private PresupuestoService presupuestoService;

	@GetMapping("/carreraFormAdd")
	public String addCarrera(Model model) {
		Carrera carrera = new Carrera();

		model.addAttribute("carreraForm", carrera);

		return "carreraForm";

	}

	@PostMapping("/addCarrera")
	public String showCarrera(@ModelAttribute("carreraForm") Carrera carrera, Model model) {
		carrera.calcularLongitudPorVuelta();

		carreraService.save(carrera);

		return "redirect:/main/carrera";

	}

	@GetMapping("/editarCarrera/{id}")
	public String editarCarrera(@PathVariable("id") Long id, Model model) {

		if (carreraService.findById(id).isPresent()) {
			model.addAttribute("carreraForm", carreraService.findById(id).get());

			List<Presupuesto> listaPresupuesto = presupuestoService.findAll();

			model.addAttribute("listaPresupuesto", listaPresupuesto);
			return "carreraForm";
		} else {
			return "carrera";
		}
	}

	@PostMapping("editarCarrera/submit")
	public String procesarEdicion(@ModelAttribute("carreraForm") Carrera carrera) {
		carreraService.save(carrera);
		return "redirect:/main/carrera";
	}

	@GetMapping("/borrarCarrera/{id}")
	public String borrarCarrera(@PathVariable("id") Long id) {

		carreraService.findById(id).get().removeFromCarrera(carreraService.findById(id).get().getPresupuesto());
		
		carreraService.deleteById(id);

		return "redirect:/main/carrera";
	}

}
