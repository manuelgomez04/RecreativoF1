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
import com.salesianostriana.dam.recreativof1manuelgomez.services.PresupuestoService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private CocheService cocheService;

	@Autowired
	private CarreraService carreraService;

	@Autowired
	private PilotoService pilotoService;

	@Autowired
	EmpleadoService empleadoService;

	@Autowired
	private MecanicoService mecanicoService;

	@Autowired
	private ComponenteService componenteService;

	@Autowired
	private PresupuestoService presupuestoService;

	@GetMapping("/pilotos")
	public String showPiloto(Model model) {

		model.addAttribute("listaPilotos", pilotoService.findAll());
		model.addAttribute("presupuesto", presupuestoService.findById(1L).get());
		presupuestoService.modifyPresupInicial();

		return "pilotos";
	}

	@GetMapping("/mecanicos")
	public String mostrarListaMecanicos(Model model) {

		presupuestoService.modifyPresupInicial();
		model.addAttribute("listaCompletaMecanicos", mecanicoService.findAll());
		model.addAttribute("presupuesto", presupuestoService.findById(1L).get());
		return "mecanicos";
	}

	@GetMapping("/coches")
	public String showCoches(Model model) {

		model.addAttribute("listaCoches", cocheService.findAll());
		model.addAttribute("presupuesto", presupuestoService.findById(1L).get());
		return "coches";
	}

	@GetMapping("/carrera")
	public String showCarrera(Model model, Long id) {

		model.addAttribute("listaCarreras", carreraService.findAll());
		carreraService.primeraCarrera().calcularLongitudPorVuelta();
		carreraService.save(carreraService.primeraCarrera());
		model.addAttribute("listaEmpleados", empleadoService.findAll());
		model.addAttribute("presupuesto", presupuestoService.findById(1L).get());
		return "carrera";
	}

	@GetMapping("/componentes")
	public String showComponentes(Model model) {

		model.addAttribute("listaComponentes", componenteService.mostrarComponentesConCoche());
		model.addAttribute("presupuesto", presupuestoService.findById(1L).get());

		return "componentesCoches";
	}

	@GetMapping("/presupuesto")
	public String showPresupuesto(Model model) {

		model.addAttribute("prespuesto", presupuestoService.findAll());
		return "presupuesto";
	}

}
