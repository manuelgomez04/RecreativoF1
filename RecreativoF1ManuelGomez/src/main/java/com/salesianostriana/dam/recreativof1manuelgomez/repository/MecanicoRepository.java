package com.salesianostriana.dam.recreativof1manuelgomez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Mecanico;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

	
}
