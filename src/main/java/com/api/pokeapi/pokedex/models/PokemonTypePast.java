package com.api.pokeapi.pokedex.models;

import java.util.List;

public class PokemonTypePast {
    private Generation generation;
    private List<TypeName> types;

    public Generation getGeneration() {
        return generation;
    }
    public void setGeneration(Generation generation) {
        this.generation = generation;
    }
    public List<TypeName> getTypes() {
        return types;
    }
    public void setTypes(List<TypeName> types) {
        this.types = types;
    }
    
}
