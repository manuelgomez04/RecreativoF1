package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.recreativof1manuelgomez.services.PresupuestoService;

@Controller
@RequestMapping("/admin/presupuesto")
public class PresupuestoController {

	@Autowired
	private PresupuestoService presupuestoService;

	@GetMapping("/mostrarPresupuesto")
	public String showPresupuesto(Model model) {


		model.addAttribute("presupuesto", presupuestoService.findAll());

		model.addAttribute("presupuestoF", presupuestoService.calcularResultado());

		return "presupuesto";
	}
}
