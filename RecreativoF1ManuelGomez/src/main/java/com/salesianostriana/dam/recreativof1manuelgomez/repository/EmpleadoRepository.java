package com.salesianostriana.dam.recreativof1manuelgomez.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	Optional<Empleado> findFirstByUsername(String username);
	

//	@Query("""
//			SELECT e FROM Empleado e
//			WHERE e.salario > :salario
//			""")
//	
//	public List <Empleado> empleadosConMayorSueldo (@Param("salario") double salario);
//	
//	
//	
//	@Query ("""
//			SELECT e FROM Empleado e
//			WHERE type(e) = Mecanico
//			""")
//	public List <Mecanico> todosLosMecanicos ();

}
