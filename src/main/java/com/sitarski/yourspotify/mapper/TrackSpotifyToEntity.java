package com.sitarski.yourspotify.mapper;

import com.sitarski.yourspotify.domain.entity.Track;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TrackSpotifyToEntity {

	public Track map(com.wrapper.spotify.model_objects.specification.Track spotifyTrack) {

		Track entityTrack = new Track();

		String artists = new ArrayList<>(Arrays.asList(spotifyTrack.getArtists()))
				.stream()
				.map(ArtistSimplified::getName)
				.collect(Collectors.joining());

		entityTrack.setArtistNames(artists);
		entityTrack.setDiscNumber(spotifyTrack.getDiscNumber());
		entityTrack.setDurationMs(spotifyTrack.getDurationMs());
		entityTrack.setHref(spotifyTrack.getHref());
		entityTrack.setId(spotifyTrack.getId());
		entityTrack.setName(spotifyTrack.getName());
		entityTrack.setPopularity(spotifyTrack.getPopularity());
		entityTrack.setType(spotifyTrack.getType().getType());
		entityTrack.setUri(spotifyTrack.getUri());

		return entityTrack;
	}
}
