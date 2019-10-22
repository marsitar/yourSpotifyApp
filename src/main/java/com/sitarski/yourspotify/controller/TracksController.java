package com.sitarski.yourspotify.controller;

import com.sitarski.yourspotify.domain.dto.Track;
import com.sitarski.yourspotify.service.TrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TracksController {

	private final TrackService trackService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public TracksController(TrackService trackService) {
		this.trackService = trackService;
	}

	@GetMapping("/browser_track")
	public ModelAndView getTrackBrowser(@RequestParam(value = "track_name", required=false) String trackName){

		Map<String,Object> params = new HashMap<String, Object>();

		params.put("content", "browser_track");

		if(trackName != null){
			List<Track> tracks = trackService.getFoundByBrowserSpotifyTracks(trackName);
			List<String> favouriteTracksIds = trackService.getFavouriteTracksIds();

			params.put("tracks", tracks);
			params.put("favouriteTracksIds", favouriteTracksIds);
		}

		return new ModelAndView("home", params);
	}

	@GetMapping("/favourite_track")
	public ModelAndView getFavouriteTrack(){
		Map<String,Object> params = new HashMap<String, Object>();

		List<Track> tracks = trackService.getAllTracks();
		List<String> favouriteTracksIds = trackService.getFavouriteTracksIds();

		params.put("tracks", tracks);
		params.put("favouriteTracksIds", favouriteTracksIds);
		params.put("content", "favourite_track");

		return new ModelAndView("home", params);
	}

	@RequestMapping(value = "/favourite_track", method = RequestMethod.POST)
	public ResponseEntity<String> addTrackToFavourites(@RequestParam(value = "track_id", required=false) String id){

		logger.info("Track ID={} is to be added to database",id);

		trackService.addTrack(id);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@DeleteMapping("/favourite_track")
	public ResponseEntity<String> deleteTrackFromFavourites(@RequestParam(value = "track_id", required=false) String id){

		logger.info("Track ID={} is to be deleted from database",id);

		trackService.removeTrackById(id);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
