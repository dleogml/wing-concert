package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artist {

    private String artistId;
    private String artistName;
    private String imageUri;
    private String description;
}
