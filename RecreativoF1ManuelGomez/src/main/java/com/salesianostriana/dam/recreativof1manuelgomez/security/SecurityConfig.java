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
		http.authorizeHttpRequests(
				(authz) -> authz.requestMatchers("/CSS/**", "/JS/**", "/h2-console/**", "/Imagenes/**").permitAll()
						.requestMatchers("/admin/**").hasAnyRole("JEFEEQUIPO")
						.requestMatchers("/coche/**").hasAnyRole("MECANICO","JEFEEQUIPO")
						.requestMatchers("/main/mecanicos/**").hasAnyRole("MECANICO", "JEFEEQUIPO")
						.requestMatchers("/main/pilotos/**").hasAnyRole("PILOTO", "JEFEEQUIPO")
						.requestMatchers("/main/carrera/**").hasAnyRole("PILOTO", "JEFEEQUIPO", "MECANICO")
						.requestMatchers("/presupuesto/**").hasAnyRole("JEFEEQUIPO")
						.requestMatchers("/componentes/**").hasAnyRole("MECANICO", "JEFEEQUIPO")
						.requestMatchers("/main/coches/**").hasAnyRole("MECANICO", "JEFEEQUIPO", "PILOTO").anyRequest().authenticated())
				.formLogin((loginz) -> loginz.loginPage("/").defaultSuccessUrl("/main/carrera").permitAll())
				.logout((logoutz) -> logoutz.logoutUrl("/logout").logoutSuccessUrl("/").permitAll());

		http.csrf(csrfz -> csrfz.disable());
		http.headers(headersz -> headersz.frameOptions(frameOptionsz -> frameOptionsz.disable()));

		return http.build();

	}

}
