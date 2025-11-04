package com.api.pokeapi.pokedex.models;

import java.util.List;

public class PokemonList {
    
    private Integer count;
    private String next;
	private String previous;
    private List<PokemonResult> results;

    public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
    }
    public List<PokemonResult> getResults() {
		return results;
	}
	public void setResults(List<PokemonResult> results) {
		this.results = results;
	}

}
