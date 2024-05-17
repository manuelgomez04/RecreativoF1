package com.salesianostriana.dam.recreativof1manuelgomez.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Presupuesto;
import com.salesianostriana.dam.recreativof1manuelgomez.repository.PresupuestoRepository;
import com.salesianostriana.dam.recreativof1manuelgomez.services.base.BaseServiceImpl;

@Service
public class PresupuestoService extends BaseServiceImpl<Presupuesto, Long, PresupuestoRepository> {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private CocheService cocheService;

	public void modifyPresupInicial() {
		Presupuesto presupuesto = repository.findById(1L).get();
		presupuesto.setGastosFijos(
				empleadoService.findAll().stream().mapToDouble(empleado -> empleado.getSalario()).sum());
		repository.save(presupuesto);
	}

	public double calcularResultado() {
		Presupuesto presupuesto = repository.findById(1L).get();

		Double presupuestoFinal = 0.0;

		presupuestoFinal = presupuesto.getPresupuestoInicial() - presupuesto.getGastosFijos()
				- presupuesto.getGastosVariables() + presupuesto.getIngresosFijos() + presupuesto.getGastosVariables();

		return presupuestoFinal;
	}

	public void ingresosExtra() {

		Random rnd = new Random(System.nanoTime());
		int indiceRango = (int) Math.floor(
				cocheService.findAll().stream().mapToInt(c -> c.getPosicionCarrera()).average().getAsDouble() / 5);

		double media = cocheService.findAll().stream().mapToInt(c -> c.getPosicionCarrera()).average().getAsDouble();
		
		int rango0Desde = 1000000;
		int rango0Hasta = 1500000;
		int rango1Hasta = 999999;
		int rango1Desde = 750000;
		int rango2Hasta = 749999;
		int rango2Desde = 500000;
		int rango3Hasta = 499999;
		int rango3Desde = 100000;

		switch (indiceRango) {
			case 0:
				findById(1L).get().setIngresosVariables(rnd.nextInt(rango0Hasta - rango0Desde + 1) + rango0Desde);
				save(findById(1L).get());
				break;

			case 1:
				findById(1L).get().setIngresosVariables(rnd.nextInt(rango1Hasta - rango1Desde + 1) + rango1Desde);
				save(findById(1L).get());

				break;
			case 2:
				findById(1L).get().setIngresosVariables(rnd.nextInt(rango2Hasta - rango2Desde + 1) + rango2Desde);
				save(findById(1L).get());

				break;
			default:
				findById(1L).get().setIngresosVariables(rnd.nextInt(rango3Hasta - rango3Desde + 1) + rango3Desde);
				save(findById(1L).get());
				break;
		}
		
//		if (media>=1 && media<=5) {
//			findById(1L).get().setIngresosVariables(rnd.nextInt(rango0Hasta - rango0Desde + 1) + rango0Desde);
//			save(findById(1L).get());
//		} else if (media >5 && media<=10 ) {
//			findById(1L).get().setIngresosVariables(rnd.nextInt(rango1Hasta - rango1Desde + 1) + rango1Desde);
//			save(findById(1L).get());
//			
//		} else if (media >11 && media <= 15) {
//			findById(1L).get().setIngresosVariables(rnd.nextInt(rango2Hasta - rango2Desde + 1) + rango2Desde);
//			save(findById(1L).get());
//			
//		} else if (media> 16 && media<=20) {
//			findById(1L).get().setIngresosVariables(rnd.nextInt(rango3Hasta - rango3Desde + 1) + rango3Desde);
//			save(findById(1L).get());
//		}

	}
}
