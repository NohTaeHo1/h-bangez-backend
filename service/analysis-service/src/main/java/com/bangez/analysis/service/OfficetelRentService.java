package com.bangez.analysis.service;

import java.util.Map;

public interface OfficetelRentService {
    Map<?,?> plotGraphAvgCostByDate();
    Map<?,?> plotGraphSaleCountByDate();
    Map<?,?> plotGraphSalesCountByRegionForMonth(String date);
}
