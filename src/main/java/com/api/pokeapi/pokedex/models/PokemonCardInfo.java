package com.api.pokeapi.pokedex.models;

public class PokemonCardInfo {
	
	private Integer id;
	private String name;
	private String icon;
	private String url;
	
	public PokemonCardInfo(Integer id, String name, String icon, String url) {
		this.setId(id);
		this.setName(name);
		this.setIcon(icon);
		this.setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
