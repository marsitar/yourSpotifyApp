package com.sitarski.yourspotify.mapper;

import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Track;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TrackSpotifyToDto {

	public com.sitarski.yourspotify.domain.dto.Track map(Track spotifyTrack) {

		com.sitarski.yourspotify.domain.dto.Track dtoTrack = new com.sitarski.yourspotify.domain.dto.Track();

		String artists = new ArrayList<>(Arrays.asList(spotifyTrack.getArtists()))
				.stream()
				.map(ArtistSimplified::getName)
				.collect(Collectors.joining(", "));

		dtoTrack.setArtistNames(artists);
		dtoTrack.setDurationMs(spotifyTrack.getDurationMs());
		dtoTrack.setId(spotifyTrack.getId());
		dtoTrack.setName(spotifyTrack.getName());
		dtoTrack.setPopularity(spotifyTrack.getPopularity());
		dtoTrack.setType(spotifyTrack.getType().getType());

		return dtoTrack;
	}
}
