package api.web.dto;


import api.domain.Concert;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ConcertSaveDto {

    private String concertName;
    private String place;
    private String dateStart;
    private String dateEnd;
    private String imageUri;
    private String ticketUri;
    private String description;
    private List<String> artistId;

    @Builder
    public ConcertSaveDto(String concertName, String place, String dateStart, String dateEnd, String imageUri, String ticketUri, String description, List<String> artistId) {
        this.concertName = concertName;
        this.place = place;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.imageUri = imageUri;
        this.ticketUri = ticketUri;
        this.description = description;
        this.artistId = artistId;
    }

    public Concert toEntity() {
        return Concert.builder()
                .concertName(concertName)
                .place(place)
                .dateStart(dateStart)
                .dateEnd(dateEnd)
                .imageUri(imageUri)
                .ticketUri(ticketUri)
                .description(description)
//                .artistId(artistId)
                .build();
    }


}
