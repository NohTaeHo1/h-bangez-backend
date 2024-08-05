package com.bangez.analysis.service.impl;

import com.bangez.analysis.service.OfficetelRentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class OfficetelRentServiceImpl implements OfficetelRentService {
    @Override
    public Map<?,?> plotGraphAvgCostByDate() {
        return null;
    }

    @Override
    public Map<?,?> plotGraphSaleCountByDate() {
        return null;

    }
    @Override
    public Map<?,?> plotGraphSalesCountByRegionForMonth(String date) {
        return null;

    }

}
