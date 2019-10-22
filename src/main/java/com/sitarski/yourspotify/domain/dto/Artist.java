package com.sitarski.yourspotify.domain.dto;

public class Artist {

	private String id;

	private String genres;

	private String name;

	private Integer popularity;

	private String type;

	public Artist() {
	}

	public Artist(String id, String genres, String name, Integer popularity, String type) {
		this.id = id;
		this.genres = genres;
		this.name = name;
		this.popularity = popularity;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Artist{" +
				"id='" + id + '\'' +
				", genres='" + genres + '\'' +
				", name='" + name + '\'' +
				", popularity=" + popularity +
				", type='" + type + '\'' +
				'}';
	}
}
