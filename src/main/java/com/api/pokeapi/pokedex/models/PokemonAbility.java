package com.api.pokeapi.pokedex.models;

public class PokemonAbility {
    private Ability ability;
    private Boolean is_hidden;
    private Integer slot;

    public Ability getAbility() {
        return ability;
    }
    public void setAbility(Ability ability) {
        this.ability = ability;
    }
    public Boolean getIs_hidden() {
        return is_hidden;
    }
    public void setIs_hidden(Boolean is_hidden) {
        this.is_hidden = is_hidden;
    }
    public Integer getSlot() {
        return slot;
    }
    public void setSlot(Integer slot) {
        this.slot = slot;
    }
    
}
