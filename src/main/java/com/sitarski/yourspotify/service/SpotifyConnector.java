package com.sitarski.yourspotify.service;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SpotifyConnector {

	private final String clientId;
	private final String clientSecret;

	private SpotifyApi spotifyApi;
	private ClientCredentialsRequest clientCredentialsRequest;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	SpotifyConnector(){
		clientId = PropertyService.getProperty("clientId");
		clientSecret = PropertyService.getProperty("clientSecret");
	}

	public SpotifyApi prepareUsableSpotifyApi(){

		logger.info("Spotify api object is to be set and adjust to useful form");

		buildSpotifyApi();
		buildCredentialsRequest();
		try {
			final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
			spotifyApi.setAccessToken(clientCredentials.getAccessToken());
		} catch (IOException | SpotifyWebApiException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return spotifyApi;
	}

	private void buildSpotifyApi() {

		logger.info("Spotify api object values are to be set");

		spotifyApi = new SpotifyApi.Builder()
				.setClientId(clientId)
				.setClientSecret(clientSecret)
				.build();
	}

	private void buildCredentialsRequest() {

		logger.info("Credential request object is to be build");

		clientCredentialsRequest = spotifyApi.clientCredentials()
				.build();
	}
}
