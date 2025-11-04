package com.api.pokeapi.pokedex.models;

import java.util.List;

public class PokemonMove {
    private Move move;
    private List<VersionGroupDetails> version_group_details;

    public Move getMove() {
        return move;
    }
    public void setMove(Move move) {
        this.move = move;
    }
    public List<VersionGroupDetails> getVersion_group_details() {
        return version_group_details;
    }
    public void setVersion_group_details(List<VersionGroupDetails> version_group_details) {
        this.version_group_details = version_group_details;
    }
    
}
