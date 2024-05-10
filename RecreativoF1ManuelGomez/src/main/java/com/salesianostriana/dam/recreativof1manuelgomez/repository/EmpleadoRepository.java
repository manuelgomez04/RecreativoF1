package com.salesianostriana.dam.recreativof1manuelgomez.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	Optional<Empleado> findFirstByUsername(String username);

}
