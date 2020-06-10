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

    private String concertName;
    private String dateStart;
    private String dateEnd;
    private String ticketUri;
    private String imageUri;
    private String place;
    private String description;
    private List<String> artistList;

    @Transient
    private List<Artist> artistInfo;

    public Concert withArtistInfo(Artist artist) {
        List<Artist> data = this.getArtistInfo();
        data.add(artist);
        this.setArtistInfo(data);
        return this;
    }


    @Builder
    public Concert(String concertName, String dateStart, String dateEnd, String ticketUri,
                   String imageUri, String place, String description, List<String> artistList){
        this.concertName = concertName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ticketUri = ticketUri;
        this.imageUri = imageUri;
        this.place = place;
        this.description = description;
        this.artistList = artistList;
    }

}