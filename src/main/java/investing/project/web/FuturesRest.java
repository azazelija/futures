package investing.project.web;

import investing.project.dto.ShortFuturesDto;
import investing.project.service.FuturesService;
import investing.project.service.SeleniumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/futures")
public class FuturesRest {

    @Autowired
    FuturesService futuresService;

    @Autowired
    SeleniumService seleniumService;

    @GetMapping("/{future}")
    public ResponseEntity<String> getFutures(@PathVariable String future) {
        String value = futuresService.getInvestingIndex(future);

        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ShortFuturesDto> getAllFutures() {
        ShortFuturesDto shortFuturesDto = futuresService.getAllInvestingIndexes();

        return new ResponseEntity<>(shortFuturesDto, HttpStatus.OK);
    }

    @GetMapping("/selenium/short")
    public ResponseEntity<ShortFuturesDto> getSeleniumShortFuture() {
        ShortFuturesDto shortFuturesDto = seleniumService.load();
        return new ResponseEntity<>(shortFuturesDto, HttpStatus.OK);
    }

    @GetMapping("/restart")
    public ResponseEntity restartSelenium() {
        seleniumService.restart();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
