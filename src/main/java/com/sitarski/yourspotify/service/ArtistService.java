package com.sitarski.yourspotify.service;

import com.sitarski.yourspotify.dao.ArtistRepository;
import com.sitarski.yourspotify.domain.entity.Artist;
import com.sitarski.yourspotify.mapper.ArtistEntityToDto;
import com.sitarski.yourspotify.mapper.ArtistSpotifyToEntity;
import com.sitarski.yourspotify.mapper.ArtistSpotifyToDto;
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
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private ArtistEntityToDto artistEntityToDto;

	@Autowired
	private ArtistSpotifyToEntity artistSpotifyToEntity;

	@Autowired
	private ArtistSpotifyToDto artistSpotifyToDto;

	@Autowired
	private SpotifyConnector spotifyConnector;

	@Autowired
	private GenericItemSearch genericItemSearch;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<com.sitarski.yourspotify.domain.dto.Artist> getAllArtists() {

		logger.info("Artist objects are to be get from database");

		List<Artist> allEntityArtists = artistRepository.findAll();

		List<com.sitarski.yourspotify.domain.dto.Artist> allDtoArtists = new ArrayList<>();

		allEntityArtists.forEach(
				entityArtist -> {
					com.sitarski.yourspotify.domain.dto.Artist dtoArtist = artistEntityToDto
							.map(entityArtist);
					allDtoArtists.add(dtoArtist);
				}
		);

		return allDtoArtists;
	}

	public com.sitarski.yourspotify.domain.dto.Artist getArtistById(String id) {

		logger.info("Artist ID={} is to be get from database",id);

		Optional<Artist> entityArtist = artistRepository.findById(id);

		return artistEntityToDto.map(entityArtist.orElse(new Artist()));
	}

	public void removeArtistById(String id) {

		logger.info("Artist ID={} is to be removed from database");

		artistRepository.deleteById(id);
	}

	public void addArtist(String id) {

		logger.info("Artist ID={} is to be added to database form remote spotify database");

		SpotifyApi spotifyApi = spotifyConnector.prepareUsableSpotifyApi();

		com.wrapper.spotify.model_objects.specification.Artist spotifyArtist = genericItemSearch
				.generateByID("artist", id, spotifyApi);

		Artist entityArtist = artistSpotifyToEntity.map(spotifyArtist);
		artistRepository.save(entityArtist);
	}

	public List<com.sitarski.yourspotify.domain.dto.Artist> getFoundByBrowserSpotifyArtists(String artistName) {

		logger.info("Artist objects like name={} are to be get from spotify remote database");

		SpotifyApi spotifyApi = spotifyConnector.prepareUsableSpotifyApi();

		List<com.wrapper.spotify.model_objects.specification.Artist> spotifyArtists = genericItemSearch
				.generateByPattern("artist", artistName, spotifyApi);
		List<com.sitarski.yourspotify.domain.dto.Artist> dtoArtists = new ArrayList<>();

		if(spotifyArtists!=null) {
			spotifyArtists.forEach(spotifyArtist -> {
				dtoArtists.add(artistSpotifyToDto.map(spotifyArtist));
			});
		}
		return dtoArtists;
	}

	public List<String> getFavouriteArtistsIds(){

		logger.info("Artist objects IDs are to be get from database");

		return getAllArtists()
				.stream()
				.map(com.sitarski.yourspotify.domain.dto.Artist::getId)
				.collect(Collectors.toList());
	}
}
