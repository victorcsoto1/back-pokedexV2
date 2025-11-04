package com.api.pokeapi.pokedex.models;

import java.util.List;

public class AbilityInfo {
	private Integer id;
	private String name;
	private List<EffectEntry> effect_entries;
	
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
	public List<EffectEntry> getEffect_entries() {
		return effect_entries;
	}
	public void setEffect_entries(List<EffectEntry> effect_entries) {
		this.effect_entries = effect_entries;
	}
	
}
