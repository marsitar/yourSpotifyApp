package com.sitarski.yourspotify.domain.dto;

public class Track {

	private String id;

	private String artistNames;

	private Integer durationMs;

	private String name;

	private Integer popularity;

	private String type;

	public Track() {
	}

	public Track(String id, String artistNames, Integer durationMs, String name, Integer popularity, String type) {
		this.id = id;
		this.artistNames = artistNames;
		this.durationMs = durationMs;
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

	public String getArtistNames() {
		return artistNames;
	}

	public void setArtistNames(String artistNames) {
		this.artistNames = artistNames;
	}

	public Integer getDurationMs() {
		return durationMs;
	}

	public void setDurationMs(Integer durationMs) {
		this.durationMs = durationMs;
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
		return "Track{" +
				"id='" + id + '\'' +
				", artistNames='" + artistNames + '\'' +
				", durationMs=" + durationMs +
				", name='" + name + '\'' +
				", popularity='" + popularity + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
