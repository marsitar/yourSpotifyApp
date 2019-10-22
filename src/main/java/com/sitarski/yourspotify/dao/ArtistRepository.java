package com.sitarski.yourspotify.dao;

import com.sitarski.yourspotify.domain.entity.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, String> {

	List<Artist> findAll();

}
