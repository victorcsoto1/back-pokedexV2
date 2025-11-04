package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpriteSet {
	
	@JsonProperty("back_default")
    private String backDefault;

    @JsonProperty("back_gray")
    private String backGray;

    @JsonProperty("back_transparent")
    private String backTransparent;

    @JsonProperty("front_default")
    private String frontDefault;

    @JsonProperty("front_gray")
    private String frontGray;

    @JsonProperty("front_transparent")
    private String frontTransparent;

    @JsonProperty("back_shiny")
    private String backShiny;

    @JsonProperty("front_shiny")
    private String frontShiny;

    @JsonProperty("back_female")
    private String backFemale;

    @JsonProperty("front_female")
    private String frontFemale;

    @JsonProperty("back_shiny_female")
    private String backShinyFemale;

    @JsonProperty("front_shiny_female")
    private String frontShinyFemale;
    
    @JsonProperty("back_shiny_transparent")
    private String backShinyTransparent;
    
    @JsonProperty("front_shiny_transparent")
    private String frontShinyTransparent;

	public String getBackDefault() {
		return backDefault;
	}

	public void setBackDefault(String backDefault) {
		this.backDefault = backDefault;
	}
	
	public String getBackGray() {
		return backGray;
	}

	public void setBackGray(String backGray) {
		this.backGray = backGray;
	}
	
	public String getBackTransparent() {
		return backTransparent;
	}

	public void setBackTransparent(String backTransparent) {
		this.backTransparent = backTransparent;
	}
	
	public String getFrontDefault() {
		return frontDefault;
	}

	public void setFrontDefault(String frontDefault) {
		this.frontDefault = frontDefault;
	}
	
	public String getFrontGray() {
		return frontGray;
	}

	public void setFrontGray(String frontGray) {
		this.frontGray = frontGray;
	}
	
	public String getFrontTransparent() {
		return frontTransparent;
	}

	public void setFrontTransparent(String frontTransparent) {
		this.frontTransparent = frontTransparent;
	}
	
	public String getBackShiny() {
		return backShiny;
	}

	public void setBackShiny(String backShiny) {
		this.backShiny = backShiny;
	}
	
	public String getFrontShiny() {
		return frontShiny;
	}

	public void setFrontShiny(String frontShiny) {
		this.frontShiny = frontShiny;
	}
	
	public String getBackFemale() {
		return backFemale;
	}

	public void setBackFemale(String backFemale) {
		this.backFemale = backFemale;
	}
	
	public String getFrontFemale() {
		return frontFemale;
	}

	public void setFrontFemale(String frontFemale) {
		this.frontFemale = frontFemale;
	}
	
	public String getBackShinyFemale() {
		return backShinyFemale;
	}

	public void setBackShinyFemale(String backShinyFemale) {
		this.backShinyFemale = backShinyFemale;
	}
	
	public String getFrontShinyFemale() {
		return frontShinyFemale;
	}

	public void setFrontShinyFemale(String frontShinyFemale) {
		this.frontShinyFemale = frontShinyFemale;
	}
	
	public String getBackShinyTransparent() {
		return backShinyTransparent;
	}

	public void setBackShinyTransparent(String backShinyTransparent) {
		this.backShinyTransparent = backShinyTransparent;
	}

	public String getFrontShinyTransparent() {
		return frontShinyTransparent;
	}

	public void setFrontShinyTransparent(String frontShinyTransparent) {
		this.frontShinyTransparent = frontShinyTransparent;
	}

}
