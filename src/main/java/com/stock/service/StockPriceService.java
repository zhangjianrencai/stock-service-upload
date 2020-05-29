package com.stock.service;


import com.stock.entity.StockPrice;

public interface StockPriceService {

    public void save(StockPrice stockPrice);
    
    public Object companyStockPrice(String companyName, String startDate, String endDate);

}
