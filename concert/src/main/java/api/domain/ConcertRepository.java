package api.domain;

import api.domain.Concert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends MongoRepository<Concert, Long> {
//    List<Concert> findByArtistId(String id);

}
