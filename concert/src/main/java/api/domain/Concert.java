package api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "concert")
public class Concert {
    @Id
    private ObjectId id;

    private String concertId;
    private String concertName;
    private String dateStart;
    private String dateEnd;
    private String ticketUri;
    private String imageUri;
    private String place;
    private String description;
    private List<String> artistIdList;

    @Transient
    private List<Artist> artistList;

    @Builder
    public Concert(String concertId, String concertName, String dateStart, String dateEnd, String ticketUri,
                   String imageUri, String place, String description, List<String> artistIdList){
        this.concertId = concertId;
        this.concertName = concertName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ticketUri = ticketUri;
        this.imageUri = imageUri;
        this.place = place;
        this.description = description;
        this.artistIdList = artistIdList;
    }

}