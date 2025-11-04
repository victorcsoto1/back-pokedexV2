package com.api.pokeapi.pokedex.models;

import java.util.Map;

public class EffectEntry {
	
	private String effect;
	private String short_effect;
	private Map<String, String> language;
	
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getShort_effect() {
		return short_effect;
	}
	public void setShort_effect(String short_effect) {
		this.short_effect = short_effect;
	}
	public Map<String, String> getLanguage() {
		return language;
	}
	public void setLanguage(Map<String, String> language) {
		this.language = language;
	}

}
