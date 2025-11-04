package com.api.pokeapi.pokedex.models;

public class VersionGameIndex {
    private Integer game_index;
    private VersionName version;
    
    public Integer getGame_index() {
        return game_index;
    }
    public void setGame_index(Integer game_index) {
        this.game_index = game_index;
    }
    public VersionName getVersion() {
        return version;
    }
    public void setVersion(VersionName version) {
        this.version = version;
    }

    
}
