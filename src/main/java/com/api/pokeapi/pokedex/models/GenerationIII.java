package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerationIII {

	private SpriteSet emerald;
	
	@JsonProperty("firered-leafgreen")
	private SpriteSet fireredLeafgreen;
	
	@JsonProperty("ruby-sapphire")
	private SpriteSet rubySapphire;

	public SpriteSet getEmerald() {
		return emerald;
	}

	public void setEmerald(SpriteSet emerald) {
		this.emerald = emerald;
	}

	public SpriteSet getFireredLeafgreen() {
		return fireredLeafgreen;
	}

	public void setFireredLeafgreen(SpriteSet fireredLeafgreen) {
		this.fireredLeafgreen = fireredLeafgreen;
	}

	public SpriteSet getRubySapphire() {
		return rubySapphire;
	}

	public void setRubySapphire(SpriteSet rubySapphire) {
		this.rubySapphire = rubySapphire;
	}
	
	
}
