package com.salesianostriana.dam.recreativof1manuelgomez.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.exception.ProductoNoEncontradoException;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Componente;
import com.salesianostriana.dam.recreativof1manuelgomez.model.Presupuesto;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.ComponenteRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

import jakarta.annotation.PostConstruct;

@Service
public class ComponenteService extends BaseServiceImpl<Componente, Long, ComponenteRepository> {

	@Autowired
	private PresupuestoService presupuestoService;

	@Autowired
	private CocheService cocheService;

	public List<Componente> mostrarComponentesSinCoche() {

		return this.repository.findComponenteSinCoche();
	}

	public List<Componente> mostrarComponentesConCoche() {
		return this.repository.findComponenteConCoche();
	}

	//Este método me suma el precio de los componentes y me lo setea a los gastos variables, actualizándolo
	public void sumarPrecioAGastos(Long id) {

		Presupuesto presupuesto = presupuestoService.findById(1L).get();
		presupuesto.setGastosVariables(presupuesto.getGastosVariables() + this.repository.findById(id).get().getPrecio());

		presupuestoService.save(presupuesto);

	}
	
	
	// Método para crear un componente igual al comprado.
	public Componente componenteComprado(Long id) {
		Componente componente;

		componente = Componente.builder().carreraComponente(findById(id).get().getCarreraComponente())
				.durabilidad(findById(id).get().getDurabilidad()).estaDaniado(findById(id).get().isEstaDaniado())
				.jefeComponente(findById(id).get().getJefeComponente()).precio(findById(id).get().getPrecio())
				.marca(findById(id).get().getMarca()).tipoComponente(findById(id).get().getTipoComponente()).build();
		this.repository.save(componente);

		return componente;
	}

	//Método para buscar un componente por su nombre. Si el componente no está, me devuelve una excepción
	public List<Componente> buscarPorNombre(String busqueda) {
		List<Componente> result = this.repository
				.findByTipoComponenteContainsIgnoreCaseOrMarcaContainsIgnoreCaseAndCocheComponenteIsNull(busqueda,
						busqueda);
		if (result.isEmpty()) {
			throw new ProductoNoEncontradoException("No hay productos con ese criterio");
		}
		return result;
	}

	//Este método me setea el estado de los componente de un coche mediante un random.
	@PostConstruct
	public void estadoComponentes() {

		Random rnd = new Random();
		List<Componente> componentes = repository.findComponenteConCoche();

		List<Componente> updatedComponentes = componentes.stream().peek(c -> c.setEstaDaniado(rnd.nextBoolean()))
				.collect(Collectors.toList());

		repository.saveAll(updatedComponentes);

		cocheService.cochesDaniados();
	}
}
