package com.salesianostriana.dam.recreativof1manuelgomez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.recreativof1manuelgomez.repository.EmpleadoRepository;

@Service
public class EmpleadoDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return empleadoRepository.findFirstByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Error al buscar el usuario"));
	}

}
