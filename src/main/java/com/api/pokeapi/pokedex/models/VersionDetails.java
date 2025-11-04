package com.api.pokeapi.pokedex.models;

public class VersionDetails {
    public Integer rarity;
    public VersionName version;

    public Integer getRarity() {
        return rarity;
    }
    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }
    public VersionName getVersion() {
        return version;
    }
    public void setVersion(VersionName version) {
        this.version = version;
    }

}
