package api.web.dto;

import api.domain.Artist;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ConcertUpdateDto {
    private String concertName;
    private String dateStart;
    private String dateEnd;
    private String place;
    private String ticketUri;
    private String imageUri;
    private String description;
    private List<String> artistIdList;

    @Builder
    public ConcertUpdateDto(String concertName, String dateStart, String dateEnd, String place, String ticketUri, String imageUri, String description, List<String> artistIdList) {
        this.concertName = concertName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.place = place;
        this.ticketUri = ticketUri;
        this.imageUri = imageUri;
        this.description = description;
        this.artistIdList = artistIdList;
    }
}
