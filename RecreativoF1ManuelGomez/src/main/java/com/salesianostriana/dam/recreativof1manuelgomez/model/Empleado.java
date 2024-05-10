package com.salesianostriana.dam.recreativof1manuelgomez.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado implements UserDetails{

	@Id
	@GeneratedValue
	private long idEmpleado;


	private String nombre;
	private String apellidos;
	private String dni;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaNacimiento;

	private double salario;
	private double incentivo;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_empleado_carrera"))
	private Carrera carreraEmpleado;

	private String username;
	private String password;
	private boolean isAdmin;
	private boolean isMecanico;
	private boolean isPiloto;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		
		if (isAdmin) {
			role += (isAdmin) ? "JEFEEQUIPO" : "USER";
		} if (isMecanico) {
			role += (isMecanico) ? "MECANICO" : "USER";
		} if (isPiloto) {
			role += (isPiloto) ? "PILOTO" : "USER";
		}
		return List.of(new SimpleGrantedAuthority(role));

	}	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
