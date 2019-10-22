package com.sitarski.yourspotify.service;

import com.sitarski.yourspotify.dao.TrackRepository;
import com.sitarski.yourspotify.domain.entity.Track;
import com.sitarski.yourspotify.mapper.TrackEntityToDto;
import com.sitarski.yourspotify.mapper.TrackSpotifyToEntity;
import com.sitarski.yourspotify.mapper.TrackSpotifyToDto;
import com.wrapper.spotify.SpotifyApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TrackService {

	@Autowired
	private TrackRepository trackRepository;

	@Autowired
	private TrackSpotifyToEntity trackSpotifyToEntity;

	@Autowired
	private TrackEntityToDto trackEntityToDto;

	@Autowired
	private TrackSpotifyToDto trackSpotifyToDto;

	@Autowired
	private SpotifyConnector spotifyConnector;

	@Autowired
	private GenericItemSearch genericItemSearch;

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	public List<com.sitarski.yourspotify.domain.dto.Track> getAllTracks() {

		logger.info("Track objects are to be get from database");

		List<Track> allEntityTracks = trackRepository.findAll();

		List<com.sitarski.yourspotify.domain.dto.Track> allDtoTracks = new ArrayList<>();

		allEntityTracks.forEach(
				entityTrack -> {
					com.sitarski.yourspotify.domain.dto.Track dtoTrack = trackEntityToDto.map(entityTrack);
					allDtoTracks.add(dtoTrack);
				}
		);

		return allDtoTracks;
	}

	public com.sitarski.yourspotify.domain.dto.Track getTrackById(String id) {

		logger.info("Track object ID={} is to be get from database", id);

		Optional<Track> entityTrack = trackRepository.findById(id);

		return trackEntityToDto.map(entityTrack.orElse(new Track()));
	}

	public void removeTrackById(String id) {

		logger.info("Track object ID={} is to be removed from database", id);

		trackRepository.deleteById(id);
	}

	public void addTrack(String id) {

		logger.info("Track ID={} is to be added to database form remote spotify database");

		SpotifyApi spotifyApi = spotifyConnector.prepareUsableSpotifyApi();

		com.wrapper.spotify.model_objects.specification.Track spotifyTrack = genericItemSearch
				.generateByID("track", id, spotifyApi);

		Track entityTrack = trackSpotifyToEntity.map(spotifyTrack);
		trackRepository.save(entityTrack);
	}

	public List<com.sitarski.yourspotify.domain.dto.Track> getFoundByBrowserSpotifyTracks(String trackName) {

		logger.info("Track objects like name={} are to be get from spotify remote database");

		SpotifyApi spotifyApi = spotifyConnector.prepareUsableSpotifyApi();

		List<com.wrapper.spotify.model_objects.specification.Track> spotifyTracks = genericItemSearch
				.generateByPattern("track", trackName, spotifyApi);
		List<com.sitarski.yourspotify.domain.dto.Track> dtoTracks = new ArrayList<>();

		if(spotifyTracks!=null) {
			spotifyTracks.forEach(spotifyTrack -> dtoTracks.add(trackSpotifyToDto.map(spotifyTrack)));
		}

		return dtoTracks;
	}

	public List<String> getFavouriteTracksIds(){

		logger.info("Track objects IDs are to be get from database");

		return getAllTracks()
				.stream()
				.map(com.sitarski.yourspotify.domain.dto.Track::getId)
				.collect(Collectors.toList());
	}
}
