package api.web;

import api.service.ConcertService;
import api.web.dto.ConcertResponseDto;
import api.web.dto.ConcertSaveDto;
import api.web.dto.ConcertUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Concert Controller")
@RestController
@CrossOrigin
@AllArgsConstructor
public class ConcertController {

    private ConcertService concertService;

    @ApiOperation(value = "콘서트 전체 검색")
    @GetMapping(value = "/api/concert")
    private List<ConcertResponseDto> getAllConcertById() {
        return concertService.findAll();
    }

    @ApiOperation(value = "콘서트 상세 검색")
    @GetMapping(value = "/api/concert/{id}")
    private ConcertResponseDto getConcertById(@PathVariable("id") String concertId) {
        return concertService.findByConcertId(concertId);
    }

    @ApiOperation(value = "콘서트 저장")
    @PostMapping(value = "/api/concert")
    private ObjectId save(@RequestBody ConcertSaveDto concertSaveDto) {
        return concertService.save(concertSaveDto);
    }

    @ApiOperation(value = "콘서트 삭제")
    @DeleteMapping(value = "/api/concert/{id}")
    private String delete(@PathVariable("id") String concertId){
        return concertService.delete(concertId);
    }

    @ApiOperation(value = "콘서트 수정")
    @PutMapping(value = "/api/concert/{id}")
    private ObjectId update(@PathVariable("id") String concertId, @RequestBody ConcertUpdateDto concertUpdateDto) {
        return concertService.update(concertId, concertUpdateDto);
    }

}
