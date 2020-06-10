package api.clients;

import api.domain.Artist;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(url = "http://localhost:8003", value = "artist")
public interface ArtistClient {

    @GetMapping("/api/artist/{id}")
    Artist getArtist(@PathVariable String id);

//    public Artist getArtist(String artistId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String serviceUri = String.format("http://localhost:8081/api/artist/%s", artistId);
//
//        ResponseEntity<Artist> restExchange =
//                restTemplate.exchange(
//                        serviceUri,
//                        HttpMethod.GET,
//                        null,
//                        Artist.class,
//                        artistId
//                );
//
//        return restExchange.getBody();
//    }
}
