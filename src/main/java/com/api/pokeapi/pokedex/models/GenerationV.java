package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerationV {
	
	@JsonProperty("black-white")
	private SpriteSet blackWhite;

	public SpriteSet getBlackWhite() {
		return blackWhite;
	}

	public void setBlackWhite(SpriteSet blackWhite) {
		this.blackWhite = blackWhite;
	}

}
