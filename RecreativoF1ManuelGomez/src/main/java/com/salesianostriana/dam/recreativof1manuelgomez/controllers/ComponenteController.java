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
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/editCoche1/{id}")
	public String editarComponente1(@PathVariable("id") Long id, Model model) {

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
	
	@GetMapping("/editCoche2/{id}")
	public String editarComponente2(@PathVariable("id") Long id, Model model) {

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
		return "redirect:/componentes/coche1";
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

		model.addAttribute("componente", componenteService.componenteComprado(id));

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

	@GetMapping("/{id}")
	public String componentesCoche1(Model model, @PathVariable("id")Long id) {

		model.addAttribute("componentes1", cocheService.findById(id).get().getListaComponentes());

		return "componentesCoche1";
	}

		
	@GetMapping("borrarComponentesCoche1/{id}")
	public String borrarComponente(@PathVariable("id") Long id) {

		componenteService.findById(id).get().removeFromCoche(componenteService.findById(id).get().getCocheComponente());

		componenteService.delete(componenteService.findById(id).get());

		return "redirect:/componentes/coche1";
	}
	
	@GetMapping("borrarComponentesCoche2/{id}")
	public String borrarComponente2(@PathVariable("id") Long id) {

		componenteService.findById(id).get().removeFromCoche(componenteService.findById(id).get().getCocheComponente());
		componenteService.delete(componenteService.findById(id).get());

		return "redirect:/componentes/coche2";
	}
	
	@GetMapping("/buscarComponente")
    public String buscarMerchPorNombre(Model model, @RequestParam("busqueda") String busqueda) {
        model.addAttribute("presupuesto", presupuestoService.findById(1L).get());

        model.addAttribute("listaComponentesComprar", componenteService.buscarPorNombre(busqueda));
        return "componentesComprar";
    }
}
