package com.api.pokeapi.pokedex.models;

public class PokemonType {
    private Integer slot;
    private TypeName type;

    public Integer getSlot() {
        return slot;
    }
    public void setSlot(Integer slot) {
        this.slot = slot;
    }
    public TypeName getType() {
        return type;
    }
    public void setType(TypeName type) {
        this.type = type;
    }
    
}
