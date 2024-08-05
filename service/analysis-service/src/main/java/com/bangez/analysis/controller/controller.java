package com.bangez.analysis.controller;

import com.bangez.analysis.service.ImportCSV;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequiredArgsConstructor
public class controller {
    private final ImportCSV importCSV;
    @PostMapping("/save_mongo")
    public void saveMongoDB() throws FileNotFoundException {
        importCSV.importCSV();
    }
}
