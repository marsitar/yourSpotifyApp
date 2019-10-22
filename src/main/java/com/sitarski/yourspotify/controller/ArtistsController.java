package com.sitarski.yourspotify.controller;

import com.sitarski.yourspotify.domain.dto.Artist;
import com.sitarski.yourspotify.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArtistsController {

	private final ArtistService artistService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public ArtistsController(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping("/browser_artist")
	public ModelAndView getArtistBrowser(@RequestParam(value = "artist_name", required=false) String artistName){

		Map<String,Object> params = new HashMap<>();

		params.put("content", "browser_artist");

		if(artistName != null){
			List<Artist> artists = artistService.getFoundByBrowserSpotifyArtists(artistName);
			List<String> favouriteArtistsIds = artistService.getFavouriteArtistsIds();

			params.put("artists", artists);
			params.put("favouriteArtistsIds", favouriteArtistsIds);
		}

		return new ModelAndView("home", params);
	}

	@GetMapping("/favourite_artist")
	public ModelAndView getFavouriteArtist(){

		Map<String,Object> params = new HashMap<>();

		List<Artist> artists = artistService.getAllArtists();
		List<String> favouriteArtistsIds = artistService.getFavouriteArtistsIds();

		params.put("content", "favourite_artist");
		params.put("favouriteArtistsIds", favouriteArtistsIds);
		params.put("artists", artists);

		return new ModelAndView("home", params);
	}

	@PostMapping("/favourite_artist")
	public ResponseEntity<String> addArtistToFavourites(@RequestParam(value = "artist_id", required=false) String id){

		logger.info("Artist ID={} is to be added to database",id);

		artistService.addArtist(id);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@DeleteMapping("/favourite_artist")
	public ResponseEntity<String> deleteArtistFromFavourites(@RequestParam(value = "artist_id", required=false) String id){

		logger.info("Artist ID={} is to be deleted from database",id);

		artistService.removeArtistById(id);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
