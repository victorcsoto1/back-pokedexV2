package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerationVI {
	
	@JsonProperty("omegaruby-alphasapphire")
	private SpriteSet oras;
	
	@JsonProperty("x-y")
	private SpriteSet xy;

	public SpriteSet getOras() {
		return oras;
	}

	public void setOras(SpriteSet oras) {
		this.oras = oras;
	}

	public SpriteSet getXy() {
		return xy;
	}

	public void setXy(SpriteSet xy) {
		this.xy = xy;
	}

}
