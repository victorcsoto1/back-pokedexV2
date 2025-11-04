package com.api.pokeapi.pokedex.models;

import java.util.List;

public class Chain {
    private List<Chain> evolves_to;
    private PokemonSpecies species;
    
    public List<Chain> getEvolves_to() {
        return evolves_to;
    }
    public void setEvolves_to(List<Chain> evolves_to) {
        this.evolves_to = evolves_to;
    }
    public PokemonSpecies getSpecies() {
        return species;
    }
    public void setSpecies(PokemonSpecies species) {
        this.species = species;
    }
}
