package com.sitarski.yourspotify.mapper;

import com.sitarski.yourspotify.domain.entity.Artist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ArtistSpotifyToEntity {

	public Artist map(com.wrapper.spotify.model_objects.specification.Artist spotifyArtist){

		Artist entityArtist = new Artist();

		String genres = new ArrayList<>(Arrays.asList(spotifyArtist.getGenres()))
				.stream()
				.collect(Collectors.joining(","));

		entityArtist.setGenres(genres);
		entityArtist.setHref(spotifyArtist.getHref());
		entityArtist.setId(spotifyArtist.getId());
		entityArtist.setName(spotifyArtist.getName());
		entityArtist.setType(spotifyArtist.getType().getType());
		entityArtist.setUri(spotifyArtist.getUri());
		entityArtist.setPopularity(spotifyArtist.getPopularity());

		return entityArtist;
	}
}
