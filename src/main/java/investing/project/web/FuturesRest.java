package investing.project.web;

import investing.project.dto.FuturesDto;
import investing.project.futures.FuturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/futures")
public class FuturesRest {

    @Autowired
    FuturesService futuresService;

    @GetMapping("/{future}")
    public ResponseEntity<String> getFutures(@PathVariable String future) {
        String value = futuresService.getInvestingIndex(future);

        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<FuturesDto> getAllFutures() {
        FuturesDto futuresDto = futuresService.getAllInvestingIndexes();

        return new ResponseEntity<>(futuresDto, HttpStatus.OK);
    }

}
