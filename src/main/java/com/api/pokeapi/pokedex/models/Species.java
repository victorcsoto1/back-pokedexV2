package com.api.pokeapi.pokedex.models;

import java.util.List;
import java.util.Map;

public class Species {
    private EvolutionChain evolution_chain;
    private List<FlavorTextEntries> flavor_text_entries;
    private Map<String, String> generation;

    public EvolutionChain getEvolution_chain() {
        return evolution_chain;
    }
    public void setEvolution_chain(EvolutionChain evolution_chain) {
        this.evolution_chain = evolution_chain;
    }
    public List<FlavorTextEntries> getFlavor_text_entries() {
        return flavor_text_entries;
    }
    public void setFlavor_text_entries(List<FlavorTextEntries> flavor_text_entries) {
        this.flavor_text_entries = flavor_text_entries;
    }
	public Map<String, String> getGeneration() {
		return generation;
	}
	public void setGeneration(Map<String, String> generation) {
		this.generation = generation;
	}
    
}
