package api.web;

import api.domain.Concert;
import api.service.ConcertService;
import api.web.dto.ConcertResponseDto;
import api.web.dto.ConcertSaveDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Concert Controller")
@RestController
@CrossOrigin
@AllArgsConstructor
public class ConcertController {
    @Autowired
    private ConcertService concertService;

    @ApiOperation(value = "콘서트 정보 검색")
    @GetMapping(value = "/api/concert")
    public List<Concert> getAllConcertById() {

        return concertService.findAll();
    }

    @ApiOperation(value = "콘서트 상세조회")
    @GetMapping(value = "/api/concert")
    public List<ConcertResponseDto> getAllConcertByArtistList() {
        return concertService.findArtistList();
    }

    @ApiOperation(value = "콘서트 저장")
    @PostMapping(value = "/api/concert")
    public ObjectId save(@RequestBody ConcertSaveDto saveDto) {
        return concertService.save(saveDto);
    }



//    @ApiOperation(value = "콘서트 참여 아티스트 정보")
//    @GetMapping(value = "/{id}")
//    public List<String> getConcertListByArtistId(@PathVariable("id") Long id) {
//        return concertService.findByArtistId(id);
//    }
}
