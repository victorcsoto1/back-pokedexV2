package com.api.pokeapi.pokedex.models;

import java.util.List;

public class Pokemon {

    private Integer id;
	private String name;
	private Integer base_experience;
	private Integer height;
	private Boolean is_default;
	private Integer order;
	private Integer weight;
	private List<PokemonAbility> abilities;
	private List<PokemonForm> forms;
	private List<VersionGameIndex> game_indices;
	private List<PokemonHeldItem> held_items;
	private String location_area_encounters;
	private List<PokemonMove> moves;
	private PokemonSprites sprites;
	private PokemonSpecies species;
	private List<PokemonStat> stats;
	private List<PokemonType> types;
	private List<PokemonTypePast> past_types;

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBaseExperience() {
		return base_experience;
	}
	public void setBaseExperience(Integer baseExperience) {
		this.base_experience = baseExperience;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Boolean getIsDefault() {
		return is_default;
	}
	public void setIsDefault(Boolean isDefault) {
		this.is_default = isDefault;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public List<PokemonAbility> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<PokemonAbility> abilities) {
		this.abilities = abilities;
	}
	public List<PokemonForm> getForms() {
		return forms;
	}
	public void setForms(List<PokemonForm> forms) {
		this.forms = forms;
	}
	public List<VersionGameIndex> getGameIndices() {
		return game_indices;
	}
	public void setGameIndices(List<VersionGameIndex> gameIndices) {
		this.game_indices = gameIndices;
	}
	public List<PokemonHeldItem> getHeldItems() {
		return held_items;
	}
	public void setHeldItems(List<PokemonHeldItem> heldItems) {
		this.held_items = heldItems;
	}
	public String getLocationAreaEncounters() {
		return location_area_encounters;
	}
	public void setLocationAreaEncounters(String locationAreaEncounters) {
		this.location_area_encounters = locationAreaEncounters;
	}
	public List<PokemonMove> getMoves() {
		return moves;
	}
	public void setMoves(List<PokemonMove> moves) {
		this.moves = moves;
	}
	public PokemonSprites getSprites() {
		return sprites;
	}
	public void setSprites(PokemonSprites sprites) {
		this.sprites = sprites;
	}
	public PokemonSpecies getSpecies() {
		return species;
	}
	public void setSpecies(PokemonSpecies species) {
		this.species = species;
	}
	public List<PokemonStat> getStats() {
		return stats;
	}
	public void setStats(List<PokemonStat> stats) {
		this.stats = stats;
	}
	public List<PokemonType> getTypes() {
		return types;
	}
	public void setTypes(List<PokemonType> types) {
		this.types = types;
	}
	public List<PokemonTypePast> getPastTypes() {
		return past_types;
	}
	public void setPastTypes(List<PokemonTypePast> pastTypes) {
		this.past_types = pastTypes;
	}
    
}
