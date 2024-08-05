package com.bangez.analysis.service;

import java.util.Map;

public interface OfficetelTradeService {
    Map<?, ?> plotGraphAvgCostByDate();
    Map<?,?> plotGraphSalesCountByRegionForMonth(String date);
    Map<?,?> plotGraphSaleCountByDate();
    Map<?,?> plotGraphCostByArea();
    Map<?,?> plotGraphCostRaisebyRegionFor3Month();
}
