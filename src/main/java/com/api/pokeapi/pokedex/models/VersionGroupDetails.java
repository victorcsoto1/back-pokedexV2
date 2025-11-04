package com.api.pokeapi.pokedex.models;

public class VersionGroupDetails {
    private Integer level_learned_at;
    private MoveLearnMethod move_learn_method;

    public Integer getLevel_learned_at() {
        return level_learned_at;
    }
    public void setLevel_learned_at(Integer level_learned_at) {
        this.level_learned_at = level_learned_at;
    }
    public MoveLearnMethod getMove_learn_method() {
        return move_learn_method;
    }
    public void setMove_learn_method(MoveLearnMethod move_learn_method) {
        this.move_learn_method = move_learn_method;
    }
    
}
