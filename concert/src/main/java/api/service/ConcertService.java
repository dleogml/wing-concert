package api.service;

import api.clients.ArtistClient;
import api.domain.Artist;
import api.domain.Concert;
import api.domain.ConcertRepository;
import api.web.dto.ConcertResponseDto;
import api.web.dto.ConcertSaveDto;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertService {
    private final ConcertRepository concertRepository;
    private final ArtistClient artistClient;

    public List<ConcertResponseDto> findAll() {
        List<Concert> concertList = concertRepository.findAll();
        List<ConcertResponseDto> responseDtos = new ArrayList<>();

        for(Concert concert : concertList) {
            List<Artist> artistList = new ArrayList<>();
            for(String artistId : concert.getArtistIdList()){
                artistList.add(artistClient.getArtist(artistId));
            }
            concert.setArtistList(artistList);
            responseDtos.add(new ConcertResponseDto(concert));
        }

        return responseDtos;
    }


    public ObjectId save(ConcertSaveDto saveDto) {
        return concertRepository.save(saveDto.toEntity()).getId();
    }

}
