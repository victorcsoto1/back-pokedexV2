package com.api.pokeapi.pokedex.models;

public class PokemonStat {
    private Integer base_stat;
    private Integer effort;
    private Stat stat;

    public Integer getBase_stat() {
        return base_stat;
    }
    public void setBase_stat(Integer base_stat) {
        this.base_stat = base_stat;
    }
    public Integer getEffort() {
        return effort;
    }
    public void setEffort(Integer effort) {
        this.effort = effort;
    }
    public Stat getStat() {
        return stat;
    }
    public void setStat(Stat stat) {
        this.stat = stat;
    }
    
}
