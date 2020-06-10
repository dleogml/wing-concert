package api.service;

import api.clients.ArtistClient;
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

    public List<Concert> findAll() {
        List<Concert> concertList = concertRepository.findAll();

        return concertList;
    }

    public List<ConcertResponseDto> findArtistList() {
        List<ConcertResponseDto> responseDtos = new ArrayList<>();
        List<Concert> concertList = concertRepository.findByArtistList();

        for(Concert concert : concertList) {
            for(String artistId : concert.getArtistList()){
                concert.withArtistInfo(artistClient.getArtist(artistId));
            }
            responseDtos.add(new ConcertResponseDto(concert));
        }

        return responseDtos;

    }

    public ObjectId save(ConcertSaveDto saveDto) {
        return concertRepository.save(saveDto.toEntity()).getId();
    }

}
