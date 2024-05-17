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
	
	//List<Componente> findByTipoComponenteContainsIgnoreCaseOrMarcaContainsIgnoreCaseOrCocheComponenteNull(String nombre, String descripcion);
	

    @Query("""
    		SELECT c FROM Componente c
    		 WHERE (UPPER(c.tipoComponente) LIKE UPPER (%:nombre%) 
    		 	OR (c.marca) LIKE UPPER (%:marca%))
    		  AND c.cocheComponente IS NULL
    		""")

    public List <Componente> listaParaBuscar(String nombre, String marca);
}
