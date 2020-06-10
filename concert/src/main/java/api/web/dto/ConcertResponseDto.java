package api.web.dto;


import api.domain.Concert;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ConcertResponseDto {

    private final String concertName;
    private final String place;
    private final String dateStart;
    private final String dateEnd;
    private final String imageUri;
    private final String tickekUri;
    private final String description;
//    private final List<String> artistList;


    public ConcertResponseDto(Concert concert) {
        this.concertName = concert.getConcertName();
        this.place = concert.getPlace();
        this.dateStart = concert.getDateStart();
        this.dateEnd = concert.getDateEnd();
        this.imageUri = concert.getImageUri();
        this.tickekUri = concert.getTicketUri();
        this.description = concert.getDescription();
//        this.artistList = concert.getArtistId();
    }
}
