package com.api.pokeapi.pokedex.models;

import java.util.Map;

public class FlavorTextEntries {
    private String flavor_text;
    private DescriptionLanguage language;
    private Map<String, String> version;

    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }

    public DescriptionLanguage getLanguage() {
        return language;
    }

    public void setLanguage(DescriptionLanguage language) {
        this.language = language;
    }

	public Map<String, String> getVersion() {
		return version;
	}

	public void setVersion(Map<String, String> version) {
		this.version = version;
	}
}
