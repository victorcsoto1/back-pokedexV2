package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerationIV {
	
	@JsonProperty("diamond-pearl")
	private SpriteSet diamondPearl;
	
	@JsonProperty("heartgold-soulsilver")
	private SpriteSet heartgoldSoulsilver;
	
	private SpriteSet platinum;

	public SpriteSet getDiamondPearl() {
		return diamondPearl;
	}

	public void setDiamondPearl(SpriteSet diamondPearl) {
		this.diamondPearl = diamondPearl;
	}

	public SpriteSet getHeartgoldSoulsilver() {
		return heartgoldSoulsilver;
	}

	public void setHeartgoldSoulsilver(SpriteSet heartgoldSoulsilver) {
		this.heartgoldSoulsilver = heartgoldSoulsilver;
	}

	public SpriteSet getPlatinum() {
		return platinum;
	}

	public void setPlatinum(SpriteSet platinum) {
		this.platinum = platinum;
	}
	
}
