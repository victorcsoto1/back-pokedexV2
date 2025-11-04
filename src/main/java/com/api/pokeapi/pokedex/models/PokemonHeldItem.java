package com.api.pokeapi.pokedex.models;

import java.util.List;

public class PokemonHeldItem {
    private Item item;
    private List<VersionDetails> version_details;
    
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public List<VersionDetails> getVersion_details() {
        return version_details;
    }
    public void setVersion_details(List<VersionDetails> version_details) {
        this.version_details = version_details;
    }

}
