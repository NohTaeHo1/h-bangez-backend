package com.bangez.analysis.service;


import com.bangez.analysis.domain.model.*;
import com.bangez.analysis.repository.*;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImportCSV {

    private final SchoolRepository repository;
    private final OfficetelTradeRepository officetelTradeRepository;
    private final OfficetelRentRepository officetelRentRepository;
    private final CityParkRepository parkRepository;
    private final AptTradeRepository aptTradeRepository;
    private final AptRentRepository aptRentRepository;

    public Flux<AptRent> importCSV() throws FileNotFoundException {

        String currentDir = System.getProperty("user.dir");
        System.out.println("Current directory: " + currentDir);

        CSVReader reader = new CSVReader(new FileReader("src/main/java/com/bangez/analysis/common/static_data/school.csv"));
        List<School> entities = new CsvToBeanBuilder<School>(reader)
                .withType(School.class)
                .build()
                .parse();

        repository.saveAll(entities).subscribe();

        CSVReader reader2 = new CSVReader(new FileReader("src/main/java/com/bangez/analysis/common/static_data/officetel_trade.csv"));
        List<OfficetelTrade> entities2 = new CsvToBeanBuilder<OfficetelTrade>(reader2)
                .withType(OfficetelTrade.class)
                .build()
                .parse();
        log.info("{}", entities2);

        officetelTradeRepository.saveAll(entities2).subscribe();

        CSVReader reader3 = new CSVReader(new FileReader("src/main/java/com/bangez/analysis/common/static_data/officetel_rent.csv"));
        List<OfficetelRent> entities3 = new CsvToBeanBuilder<OfficetelRent>(reader3)
                .withType(OfficetelRent.class)
                .build()
                .parse();

        officetelRentRepository.saveAll(entities3).subscribe();

        CSVReader reader4 = new CSVReader(new FileReader("src/main/java/com/bangez/analysis/common/static_data/city_park.csv"));
        List<CityPark> entities4 = new CsvToBeanBuilder<CityPark>(reader4)
                .withType(CityPark.class)
                .build()
                .parse();

        parkRepository.saveAll(entities4).subscribe();

        CSVReader reader5 = new CSVReader(new FileReader("src/main/java/com/bangez/analysis/common/static_data/apt_trade.csv"));
        List<AptTrade> entities5 = new CsvToBeanBuilder<AptTrade>(reader5)
                .withType(AptTrade.class)
                .build()
                .parse();

        aptTradeRepository.saveAll(entities5).subscribe();

        CSVReader reader6 = new CSVReader(new FileReader("src/main/java/com/bangez/analysis/common/static_data/apt_rent.csv"));
        List<AptRent> entities6 = new CsvToBeanBuilder<AptRent>(reader6)
                .withType(AptRent.class)
                .build()
                .parse();

        aptRentRepository.saveAll(entities6).subscribe();


        return aptRentRepository.saveAll(entities6);


    }

}