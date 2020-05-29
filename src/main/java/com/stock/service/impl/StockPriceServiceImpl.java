package com.stock.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.entity.StockPrice;
import com.stock.repository.StockPriceRepository;
import com.stock.service.StockPriceService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class StockPriceServiceImpl implements StockPriceService{

    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Override
    public void save(StockPrice stockPrice) {
    	stockPriceRepository.save(stockPrice);
    }

	@Override
	public Object companyStockPrice(String companyName, String startDate, String endDate) {
    	List<Object[]> originData =  stockPriceRepository.companyStockPrice(companyName, startDate, endDate);
    	
    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	JSONArray jsonArray=new JSONArray();
    	JSONObject jsonObject = new JSONObject();
    	ArrayList timeList=new ArrayList();
    	ArrayList priceList=new ArrayList();
    	for (int i=0; i<originData.size(); i++) {
    		Object[] obj = originData.get(i);
    		timeList.add(sdf.format(obj[1]));
    		priceList.add(obj[2]);
    	}
    	jsonObject.put("companeName", originData.get(0)[0]);
    	jsonObject.put("time", timeList);
    	jsonObject.put("price", priceList);
    	return jsonObject.toString();
	}
}


