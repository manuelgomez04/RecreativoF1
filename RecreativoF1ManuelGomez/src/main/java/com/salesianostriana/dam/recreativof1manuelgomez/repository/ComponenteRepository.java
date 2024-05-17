package com.salesianostriana.dam.recreativof1manuelgomez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.recreativof1manuelgomez.model.Componente;

public interface ComponenteRepository extends JpaRepository<Componente, Long> {

	@Query("""
			SELECT c FROM Componente c WHERE c.cocheComponente IS NULL
			""")
	public List<Componente> findComponenteSinCoche();

	@Query("""
			SELECT c FROM Componente c WHERE c.cocheComponente IS NOT NULL
			""")
	public List<Componente> findComponenteConCoche();

	@Query("""
			SELECT c FROM Componente c
			WHERE c.cocheComponente.idCoche = 1
			""")
	public List<Componente> componentesCoche1();

	@Query("""
			SELECT c FROM Componente c
			WHERE c.cocheComponente.idCoche = 2
			""")
	public List<Componente> componentesCoche2();
	
	List<Componente> findByTipoComponenteContainsIgnoreCaseOrMarcaContainsIgnoreCase(String nombre, String descripcion);
}
