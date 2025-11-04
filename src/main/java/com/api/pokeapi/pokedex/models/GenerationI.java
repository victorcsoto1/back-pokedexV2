package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerationI {
	
	@JsonProperty("red-blue")
	private SpriteSet redBlue;
	
	private SpriteSet yellow;
	
	public SpriteSet getRedBlue() {
		return redBlue;
	}

	public void setRedBlue(SpriteSet redBlue) {
		this.redBlue = redBlue;
	}

	public SpriteSet getYellow() {
		return yellow;
	}

	public void setYellow(SpriteSet yellow) {
		this.yellow = yellow;
	}

}
