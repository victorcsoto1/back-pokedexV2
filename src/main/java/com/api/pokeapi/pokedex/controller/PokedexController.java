package com.api.pokeapi.pokedex.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokeapi.pokedex.models.AbilityInfo;
import com.api.pokeapi.pokedex.models.Pokemon;
import com.api.pokeapi.pokedex.models.PokemonCardInfo;
import com.api.pokeapi.pokedex.models.PokemonList;
import com.api.pokeapi.pokedex.service.PokedexService;
import com.api.pokeapi.pokedex.models.PokemonResult;
import com.api.pokeapi.pokedex.models.Species;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PokedexController {

	private final PokedexService pokedexService;
	
	public PokedexController(PokedexService pokedexService) {
		this.pokedexService = pokedexService;
	}
	
	//
	@GetMapping("/getPokemonList")
	public List<PokemonCardInfo> getPokemonList(@RequestParam String limit) throws InterruptedException, ExecutionException {
		PokemonList listaPokemonApi = pokedexService.getPokemonList(limit);
		List<PokemonResult> result = listaPokemonApi.getResults();
		List<PokemonCardInfo> listaInfoPokemon = new ArrayList<>();
		
		List<CompletableFuture<Pokemon>> pokemonTaskList = new ArrayList<>();
		List<String> urlPokemonList = new ArrayList<>();
		for (PokemonResult r : result) {
			pokemonTaskList.add(pokedexService.getPokemonAsync(r.getUrl()));
			urlPokemonList.add(r.getUrl());
		}
		
		CompletableFuture.allOf(pokemonTaskList.toArray(new CompletableFuture[0])).join();
		
		List<Pokemon> pokemonList = new ArrayList<>();
		for (CompletableFuture<Pokemon> task : pokemonTaskList) {
			pokemonList.add(task.get());
		}
		
		if (pokemonList.size() == urlPokemonList.size()) {
			for (int i = 0; i < pokemonList.size(); i++) {
				Integer id = pokemonList.get(i).getId();
				Map<String, Map<String, Object>> versions = pokemonList.get(i).getSprites().getVersions();
				@SuppressWarnings("unchecked")
				Map<String, Object> icons = (Map<String, Object>) versions.get("generation-viii").get("icons");
				String iconPokemon = (String) icons.get("front_default");
				
				PokemonCardInfo pokemonCardInfo = new PokemonCardInfo(id, pokemonList.get(i).getName(), iconPokemon, urlPokemonList.get(i));
				listaInfoPokemon.add(pokemonCardInfo);
			}
		}
		
		return listaInfoPokemon;
	}
	
	//
	@GetMapping("/searchPokemon")
	public List<PokemonCardInfo> searchPokemonList(@RequestParam String limit, @RequestParam String searchText) throws InterruptedException, ExecutionException {
		PokemonList listaPokemon = pokedexService.getPokemonList(limit);
		List<PokemonResult> result = listaPokemon.getResults();
		List<PokemonCardInfo> filteredPokemonList = new ArrayList<>();
		
		List<CompletableFuture<Pokemon>> pokemonTaskList = new ArrayList<>();
		List<String> urlPokemonList = new ArrayList<>();
		for (PokemonResult r : result) {
			String pokemonName = r.getName();
			boolean textContainsPokemonName = pokemonName.contains(searchText);
			if (textContainsPokemonName) {
				pokemonTaskList.add(pokedexService.getPokemonAsync(r.getUrl()));
				urlPokemonList.add(r.getUrl());
			}
		}
		
		CompletableFuture.allOf(pokemonTaskList.toArray(new CompletableFuture[0])).join();
		
		List<Pokemon> pokemonList = new ArrayList<>();
		for (CompletableFuture<Pokemon> task : pokemonTaskList) {
			pokemonList.add(task.get());
		}
		
		if (pokemonList.size() == urlPokemonList.size()) {
			for (int i = 0; i < pokemonList.size(); i++) {
				Integer id = pokemonList.get(i).getId();
				Map<String, Map<String, Object>> versions = pokemonList.get(i).getSprites().getVersions();
				@SuppressWarnings("unchecked")
				Map<String, Object> icons = (Map<String, Object>) versions.get("generation-viii").get("icons");
				String iconPokemon = (String) icons.get("front_default");
				
				PokemonCardInfo pokemonCardInfo = new PokemonCardInfo(id, pokemonList.get(i).getName(), iconPokemon, urlPokemonList.get(i));
				filteredPokemonList.add(pokemonCardInfo);
			}
		}
		
		return filteredPokemonList;
	}
	
	@GetMapping("/getPokemonInfo")
	public Pokemon getPokemonInfo(@RequestParam String urlPokemon) {		
		return pokedexService.getPokemon(urlPokemon);
	}
	
	@GetMapping("/getPokemonAbility")
	public AbilityInfo getPokemonAbility(@RequestParam String urlAbility) {
		return pokedexService.getPokemonAbility(urlAbility);
	}
	
	@GetMapping("/getPokemonSpecies")
	public Species getPokemonSpecies(@RequestParam String urlSpecies) {
		return pokedexService.getPokemonSpecies(urlSpecies);
	}
	
}
