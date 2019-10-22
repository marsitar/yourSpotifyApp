package com.sitarski.yourspotify.mapper;

import com.wrapper.spotify.model_objects.specification.Artist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ArtistSpotifyToDto {

	public com.sitarski.yourspotify.domain.dto.Artist map(Artist spotifyArtist){

		com.sitarski.yourspotify.domain.dto.Artist dtoArtist = new com.sitarski.yourspotify.domain.dto.Artist();

		String genres = new ArrayList<>(Arrays.asList(spotifyArtist.getGenres()))
				.stream()
				.collect(Collectors.joining(", "));

		dtoArtist.setGenres(genres);
		dtoArtist.setId(spotifyArtist.getId());
		dtoArtist.setName(spotifyArtist.getName());
		dtoArtist.setType(spotifyArtist.getType().getType());
		dtoArtist.setPopularity(spotifyArtist.getPopularity());

		return dtoArtist;
	}
}
