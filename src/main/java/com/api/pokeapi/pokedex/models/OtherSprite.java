package com.api.pokeapi.pokedex.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtherSprite {
    private DreamWorld dream_world;
    private Home home;
    @JsonProperty("official-artwork")
    private OfficialArtwork officialArtwork;
    private Showdown showdown;
    
    public DreamWorld getDream_world() {
        return dream_world;
    }
    public void setDream_world(DreamWorld dream_world) {
        this.dream_world = dream_world;
    }
    public Home getHome() {
        return home;
    }
    public void setHome(Home home) {
        this.home = home;
    }
    public OfficialArtwork getOfficialArtwork() {
        return officialArtwork;
    }
    public void setOfficialArtwork(OfficialArtwork officialArtwork) {
        this.officialArtwork = officialArtwork;
    }
	public Showdown getShowdown() {
		return showdown;
	}
	public void setShowdown(Showdown showdown) {
		this.showdown = showdown;
	}

}
