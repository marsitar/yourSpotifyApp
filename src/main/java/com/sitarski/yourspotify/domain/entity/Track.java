package com.sitarski.yourspotify.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="track")
public class Track {

	@Id
	@Column(name="id")
	private String id;

	@Column(name="artist_names")
	@NotNull
	private String artistNames;

	@Column(name="disc_number")
	@NotNull
	private Integer discNumber;

	@Column(name="duration_ms")
	@NotNull
	private Integer durationMs;

	@Column(name="href")
	@NotNull
	private String href;

	@Column(name="name")
	@NotNull
	private String name;

	@Column(name="popularity")
	@NotNull
	private Integer popularity;

	@Column(name="type")
	@NotNull
	private String type;

	@Column(name="uri")
	@NotNull
	private String uri;

	public Track() {
	}

	public Track(String id, String artistNames, Integer discNumber, Integer durationMs, String href, String name, Integer popularity, String type, String uri) {
		this.id = id;
		this.artistNames = artistNames;
		this.discNumber = discNumber;
		this.durationMs = durationMs;
		this.href = href;
		this.name = name;
		this.popularity = popularity;
		this.type = type;
		this.uri = uri;
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

	public Integer getDiscNumber() {
		return discNumber;
	}

	public void setDiscNumber(Integer discNumber) {
		this.discNumber = discNumber;
	}

	public Integer getDurationMs() {
		return durationMs;
	}

	public void setDurationMs(Integer durationMs) {
		this.durationMs = durationMs;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "Track{" +
				"id='" + id + '\'' +
				", artistNames=" + artistNames +
				", discNumber=" + discNumber +
				", durationMs=" + durationMs +
				", href='" + href + '\'' +
				", name='" + name + '\'' +
				", popularity='" + popularity + '\'' +
				", type='" + type + '\'' +
				", uri='" + uri + '\'' +
				'}';
	}
}
