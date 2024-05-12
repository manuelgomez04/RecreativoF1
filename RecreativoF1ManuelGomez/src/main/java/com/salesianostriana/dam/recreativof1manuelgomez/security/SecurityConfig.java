package com.salesianostriana.dam.recreativof1manuelgomez.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder encoder;

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(encoder);
		return provider;
	}

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

		return authBuilder.authenticationProvider(daoAuthenticationProvider()).build();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.requestMatchers("/css/**", "/js/**", "/h2-console/**").permitAll()
				.requestMatchers("/admin/**").hasAnyRole("JEFEEQUIPO").requestMatchers("/mecanicos/**")
				.hasAnyRole("MECANICO", "JEFEEQUIPO").requestMatchers("/piloto/**").hasAnyRole("PILOTO", "JEFEEQUIPO")
				.requestMatchers("/carrera/***").hasAnyRole("PILOTO", "JEFEEQUIPO").requestMatchers("/presupuesto/**")
				.hasAnyRole("JEFEEQUIPO").requestMatchers("/componentes/**").hasAnyRole("MECANICO", "JEFEEQUIPO")
				.anyRequest().authenticated())
				.formLogin((loginz) -> loginz.loginPage("/inicioSesion").permitAll().defaultSuccessUrl("/carrera/"));

		http.csrf(csrfz -> csrfz.disable());
		http.headers(headersz -> headersz.frameOptions(frameOptionsz -> frameOptionsz.disable()));

		return http.build();

	}

}
