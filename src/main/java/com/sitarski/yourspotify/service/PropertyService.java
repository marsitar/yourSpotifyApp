package com.sitarski.yourspotify.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyService {

	private static final String SPOTIFY_FILE_NAME = "spotify.properties";
	private static Logger logger = LoggerFactory.getLogger(PropertyService.class.getName());

	public static String getProperty(String property) {

		Properties properties = new Properties();

		try {
			properties.load(Objects.requireNonNull(Thread.currentThread()
					.getContextClassLoader().getResource(SPOTIFY_FILE_NAME))
					.openStream());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		return properties.getProperty(property);
	}
}
