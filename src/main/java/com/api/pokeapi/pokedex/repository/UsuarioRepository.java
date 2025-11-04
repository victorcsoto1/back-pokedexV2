package com.api.pokeapi.pokedex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokeapi.pokedex.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByEmail(String email);
}
