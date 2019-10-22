package com.sitarski.yourspotify.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="artist")
public class Artist {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "genres")
	@NotNull
	private String genres;

	@Column(name = "href")
	@NotNull
	private String href;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "popularity")
	@NotNull
	private Integer popularity;

	@Column(name = "type")
	@NotNull
	private String type;

	@Column(name = "uri")
	@NotNull
	private String uri;

	public Artist() {
	}

	public Artist(String id,@NotNull String genres, @NotNull String href, @NotNull String name, @NotNull Integer popularity, @NotNull String type, @NotNull String uri) {
		this.id = id;
		this.genres = genres;
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

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Artist{" +
				"id='" + id + '\'' +
				", genres='" + genres + '\'' +
				", href='" + href + '\'' +
				", name='" + name + '\'' +
				", popularity=" + popularity +
				", type='" + type + '\'' +
				", uri='" + uri + '\'' +
				'}';
	}
}
