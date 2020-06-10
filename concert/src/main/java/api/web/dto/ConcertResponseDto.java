package api.web.dto;


import api.domain.Artist;
import api.domain.Concert;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ConcertResponseDto {

    private final String concertId;
    private final String concertName;
    private final String dateStart;
    private final String dateEnd;
    private final String ticketUri;
    private final String place;
    private final String imageUri;
    private final String description;
    private final List<Artist> artistList;

    public ConcertResponseDto(Concert concert) {
        this.concertId = concert.getConcertId();
        this.concertName = concert.getConcertName();
        this.place = concert.getPlace();
        this.dateStart = concert.getDateStart();
        this.dateEnd = concert.getDateEnd();
        this.imageUri = concert.getImageUri();
        this.ticketUri = concert.getTicketUri();
        this.description = concert.getDescription();
        this.artistList = concert.getArtistList();
    }
}
