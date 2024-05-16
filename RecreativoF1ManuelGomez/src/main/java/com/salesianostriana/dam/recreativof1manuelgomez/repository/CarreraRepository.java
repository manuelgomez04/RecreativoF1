package com.salesianostriana.dam.recreativof1manuelgomez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {

	@Query("""
			SELECT c FROM Carrera c
			WHERE c.id = 1
			""")
	public Carrera primeraCarrera();
}
