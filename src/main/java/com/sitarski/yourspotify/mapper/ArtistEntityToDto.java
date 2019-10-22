package com.sitarski.yourspotify.mapper;

import com.sitarski.yourspotify.domain.dto.Artist;
import org.springframework.stereotype.Service;

@Service
public class ArtistEntityToDto {

	public Artist map(com.sitarski.yourspotify.domain.entity.Artist artistEntity){

		Artist artistDto = new Artist();

		artistDto.setName(artistEntity.getName());
		artistDto.setGenres(artistEntity.getGenres());
		artistDto.setId(artistEntity.getId());
		artistDto.setPopularity(artistEntity.getPopularity());
		artistDto.setType(artistEntity.getType());

		return artistDto;
	}
}
