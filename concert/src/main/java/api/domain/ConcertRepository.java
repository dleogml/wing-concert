package api.domain;

import api.domain.Concert;
import api.web.dto.ConcertResponseDto;
import api.web.dto.ConcertUpdateDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends MongoRepository<Concert, Long> {
    Concert findByConcertId(String concertId);
    String deleteByConcertId(String concertId);

    ObjectId findByConcertId(String id, ConcertUpdateDto concertId);
}
