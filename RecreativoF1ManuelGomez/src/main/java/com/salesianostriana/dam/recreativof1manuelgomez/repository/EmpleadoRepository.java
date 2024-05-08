package com.salesianostriana.dam.recreativof1manuelgomez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
