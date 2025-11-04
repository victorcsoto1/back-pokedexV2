package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerationVII {

	private SpriteSet icons;
	
	@JsonProperty("ultrasun-ultramoon")
	private SpriteSet ultrasunUltramoon;

	public SpriteSet getUltrasunUltramoon() {
		return ultrasunUltramoon;
	}

	public void setUltrasunUltramoon(SpriteSet ultrasunUltramoon) {
		this.ultrasunUltramoon = ultrasunUltramoon;
	}

	public SpriteSet getIcons() {
		return icons;
	}

	public void setIcons(SpriteSet icons) {
		this.icons = icons;
	}
}
