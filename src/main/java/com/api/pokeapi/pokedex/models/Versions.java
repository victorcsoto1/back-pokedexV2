package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Versions {
	@JsonProperty("generation-i")
	private GenerationI generationI;
	
	@JsonProperty("generation-ii")
	private GenerationII generationII;
	
	@JsonProperty("generation-iii")
	private GenerationIII generationIII;
	
	@JsonProperty("generation-iv")
	private GenerationIV generationIV;
	
	@JsonProperty("generation-v")
	private GenerationV generationV;
	
	@JsonProperty("generation-vi")
	private GenerationVI generationVI;
	
	@JsonProperty("generation-vii")
	private GenerationVII generationVII;
	
	@JsonProperty("generation-viii")
	private GenerationVIII generationVIII;

	public GenerationI getGenerationI() {
		return generationI;
	}

	public void setGenerationI(GenerationI generationI) {
		this.generationI = generationI;
	}
	
	public GenerationII getGenerationII() {
		return generationII;
	}

	public void setGenerationII(GenerationII generationII) {
		this.generationII = generationII;
	}
	
	public GenerationIII getGenerationIII() {
		return generationIII;
	}

	public void setGenerationIII(GenerationIII generationIII) {
		this.generationIII = generationIII;
	}
	
	public GenerationIV getGenerationIV() {
		return generationIV;
	}

	public void setGenerationIV(GenerationIV generationIV) {
		this.generationIV = generationIV;
	}
	
	public GenerationV getGenerationV() {
		return generationV;
	}

	public void setGenerationV(GenerationV generationV) {
		this.generationV = generationV;
	}
	
	public GenerationVI getGenerationVI() {
		return generationVI;
	}

	public void setGenerationVI(GenerationVI generationVI) {
		this.generationVI = generationVI;
	}
	
	public GenerationVII getGenerationVII() {
		return generationVII;
	}

	public void setGenerationVII(GenerationVII generationVII) {
		this.generationVII = generationVII;
	}
	
	public GenerationVIII getGenerationVIII() {
		return generationVIII;
	}
	
	public void setGenerationVIII(GenerationVIII generationVIII) {
		this.generationVIII = generationVIII;
	}
}
