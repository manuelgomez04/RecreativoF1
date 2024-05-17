package com.salesianostriana.dam.recreativof1manuelgomez.exception;

import jakarta.persistence.EntityNotFoundException;

public class ProductoNoEncontradoException extends EntityNotFoundException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoNoEncontradoException() {
        super("No hay productos que coincidan con la búsqueda");
    }
    
    public ProductoNoEncontradoException(String msg) {
        super(msg);
    }

}
