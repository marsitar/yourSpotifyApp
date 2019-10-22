package com.sitarski.yourspotify.mapper;

import com.sitarski.yourspotify.domain.dto.Track;
import org.springframework.stereotype.Service;

@Service
public class TrackEntityToDto {

	public Track map(com.sitarski.yourspotify.domain.entity.Track trackEntity) {

		Track trackDto = new Track();

		trackDto.setArtistNames(trackEntity.getArtistNames());
		trackDto.setDurationMs(trackEntity.getDurationMs());
		trackDto.setId(trackEntity.getId());
		trackDto.setName(trackEntity.getName());
		trackDto.setPopularity(trackEntity.getPopularity());
		trackDto.setType(trackEntity.getType());

		return trackDto;
	}
}
