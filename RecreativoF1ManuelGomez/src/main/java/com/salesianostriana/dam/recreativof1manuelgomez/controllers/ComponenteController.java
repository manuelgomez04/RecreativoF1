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
import com.salesianostriana.dam.recreativof1manuelgomez.services.PresupuestoService;

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

	@Autowired
	private PresupuestoService presupuestoService;

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

		return "redirect:/main/componentes";
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
			return "componentesCoche";
		}

	}

	@PostMapping("editarComponente/submit")
	public String procesarEditarComponente(@ModelAttribute("componenteForm") Componente componente) {
		componenteService.save(componente);
		return "redirect:/main/componentes";
	}

	@GetMapping("borrar/{id}")
	public String borrarComponente(@PathVariable("id") Long id) {

		componenteService.deleteById(id);

		return "redirect:/main/componentes";
	}

	@GetMapping("/comprarComponentes")
	public String comprarComponentes(Model model, Long id) {
		model.addAttribute("presupuesto", presupuestoService.findById(1L).get());

		model.addAttribute("listaComponentesComprar", componenteService.mostrarComponentesSinCoche());

		return "componentesComprar";
	}

	@GetMapping("/comprarComponente/{id}")
	public String comprarComponente(Model model, @PathVariable("id") Long id) {

		componenteService.sumarPrecioAGastos(id);

		Componente componente;

		componente = Componente.builder().carreraComponente(componenteService.findById(id).get().getCarreraComponente())
				.durabilidad(componenteService.findById(id).get().getDurabilidad())
				.estaDaniado(componenteService.findById(id).get().isEstaDaniado())
				.jefeComponente(componenteService.findById(id).get().getJefeComponente())
				.precio(componenteService.findById(id).get().getPrecio())
				.marca(componenteService.findById(id).get().getMarca())
				.tipoComponente(componenteService.findById(id).get().getTipoComponente()).build();
		componenteService.save(componente);

		model.addAttribute("componente", componente);

		List<Coche> listaCoches = cocheService.findAll();
		List<Carrera> listaCarrerasOpcion = carreraService.findAll();
		List<JefeEquipo> listaJefeEquipoOpcion = jefeEquipoService.findAll();
		model.addAttribute("listaCoches", listaCoches);
		model.addAttribute("carrera", listaCarrerasOpcion);
		model.addAttribute("jefeEquipo", listaJefeEquipoOpcion);

		return "asignarCoche";

	}

	@PostMapping("comprarComponente/submit")
	public String componenteGuardar(@ModelAttribute("componente") Componente componente) {

		componenteService.edit(componente);

		return "redirect:/componentes/comprarComponentes";
	}

	@GetMapping("/coche1")
	public String componentesCoche1(Model model) {

		model.addAttribute("componentes1", componenteService.componentesCoche1());

		return "componentesCoche1";
	}

	@GetMapping("/coche2")
	public String componentesCoche2(Model model) {

		model.addAttribute("componentes2", componenteService.componentesCoche2());

		return "componentesCoche2";
	}
}
