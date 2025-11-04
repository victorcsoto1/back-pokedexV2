package com.api.pokeapi.pokedex.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.pokeapi.pokedex.models.AbilityInfo;
import com.api.pokeapi.pokedex.models.Pokemon;
import com.api.pokeapi.pokedex.models.PokemonList;
import com.api.pokeapi.pokedex.models.Species;

@Service
public class PokedexService {
	
	private RestTemplate restTemplate;
	private String url = "https://pokeapi.co/api/v2";
	
	public PokedexService() {
		this.restTemplate = new RestTemplate();
	}
	
	@Cacheable("pokemonListCache")
	public PokemonList getPokemonList(String limit) {
		return restTemplate.getForObject(url + "/pokemon?limit=" + limit, PokemonList.class);
	}
	
	public Pokemon getPokemon(String urlPokemon) {
		return restTemplate.getForObject(urlPokemon, Pokemon.class);
	}
	
	@Cacheable("getPokemonAsyncCache")
	@Async
	public CompletableFuture<Pokemon> getPokemonAsync(String urlPokemon) {
		return CompletableFuture.completedFuture(restTemplate.getForObject(urlPokemon, Pokemon.class));
	}
	
	public AbilityInfo getPokemonAbility(String urlAbility) {
		return restTemplate.getForObject(urlAbility, AbilityInfo.class);
	}
	
	public Species getPokemonSpecies(String urlSpecies) {
		return restTemplate.getForObject(urlSpecies, Species.class);
	}
	
}
