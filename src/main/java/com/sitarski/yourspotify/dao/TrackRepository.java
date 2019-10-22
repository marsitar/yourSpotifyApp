package com.sitarski.yourspotify.dao;

import com.sitarski.yourspotify.domain.entity.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackRepository extends CrudRepository<Track, String> {

	List<Track> findAll();
}
