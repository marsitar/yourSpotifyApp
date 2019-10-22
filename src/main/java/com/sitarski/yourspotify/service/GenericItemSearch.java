package com.sitarski.yourspotify.service;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GenericItemSearch {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public <T> List<T> generateByPattern(String itemType, String searchedText,SpotifyApi spotifyApi){

		List<T> itemsList = null;

		try {
			switch (itemType) {
				case "artist":
					itemsList = (List<T>)Arrays.asList(spotifyApi.searchArtists(searchedText).build().execute().getItems());
					break;
				case "track":
					itemsList = (List<T>)Arrays.asList(spotifyApi.searchTracks(searchedText).build().execute().getItems());
					break;
				default:
					break;
			}
		} catch (SpotifyWebApiException | IOException e) {
			logger.error(e.getMessage());
		}

		String generatedClass = null;

		if(itemsList != null && !itemsList.isEmpty()) {
			generatedClass = itemsList.get(0).getClass().getName();
		}
		logger.info("List<{}> has been generated from spotify database (pattern - {})", generatedClass, searchedText);

		return itemsList;
	}

	public <E> E generateByID(String itemType, String searchedId,SpotifyApi spotifyApi){

		E item = null;

		try {
			switch (itemType) {
				case "artist":
					item = (E)spotifyApi.getArtist(searchedId).build().execute();
					break;
				case "track":
					item = (E)spotifyApi.getTrack(searchedId).build().execute();
					break;
				default:
					break;
			}
		} catch (SpotifyWebApiException | IOException e) {
			logger.error(e.getMessage());
		}

		String generatedClass = null;

		if(item != null) {
			generatedClass = item.getClass().getName();
		}
		logger.info("Object {} has been generated from spotify database (ID - {})", generatedClass, searchedId);

		return item;
	}





}
