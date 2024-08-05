package com.bangez.analysis.controller;

import com.bangez.analysis.domain.dto.AptRentDto;
import com.bangez.analysis.router.AptRentRouter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/apt_rent")
public class AptRentController {

    private final AptRentRouter router;

    @GetMapping(path = "/statistics")
    public ResponseEntity<?> searchPlayer(
            @RequestParam(value = "select", required = true) String select,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "region", required = false) String region
    ) {
        Mono<?> monoMap = router.execute(select, date, region);

        return ResponseEntity.ok(monoMap);
    }

}

