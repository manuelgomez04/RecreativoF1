package com.salesianostriana.dam.recreativof1manuelgomez.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	Optional<Empleado> findFirstByUsername(String username);

	@Query("""
			SELECT e FROM Empleado e
			LEFT JOIN e.cochePiloto p
			LEFT JOIN e.cocheMecanico m
			WHERE( p.posicionCarrera < 10)
				OR
				(m.posicionCarrera < 10)
			""")
	public List<Empleado> todosMecanicosYPilotosCocheBuenaPosicion();

	public boolean existsByUsername(String username);

	@Query("""
			SELECT e FROM Empleado e
			WHERE e.carreraEmpleado.id = :id
			""")
	public List<Empleado> empleadosCarrera(@Param("id") Long id);

}
