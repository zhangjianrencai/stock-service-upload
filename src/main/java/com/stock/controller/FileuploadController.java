package com.stock.controller;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.stock.entity.StockPrice;
import com.stock.service.ImportService;
import com.stock.service.StockPriceService;


/**
 * 导入Excel相关的功能
 * 
 * @author JianZhang
 */
@RestController
public class FileuploadController {
	
    /**
     * 实现文件上传
     * */
    @Autowired
    private ImportService importService;
    
    @Autowired
    private StockPriceService stockPriceService;

    /**
     * 文件上传
     * 
     * @return String
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("file_data");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            if (String.valueOf(lo.get(0)).length() > 7) {
            	break;
            } else {
            	StockPrice stockPrice = new StockPrice();
            	stockPrice.setStockCode(String.valueOf(lo.get(0)).trim());
            	stockPrice.setStockExchange(String.valueOf(lo.get(1)).trim());
            	stockPrice.setCurrentPrice(String.valueOf(lo.get(2)).trim());
            	stockPrice.setDateTime(Timestamp.valueOf(sdf2.format(sdf.parse(String.valueOf(lo.get(3)).trim() + String.valueOf(lo.get(4)).trim()))));
            	stockPriceService.save(stockPrice);
            }

        }
        return "updateload success";
    }
    
    /*
     * 获取stockprice数据*/
    @GetMapping(value = "/compareData")
	public Object findAllCompanyList(@RequestParam(value="companyName") String companyName, @RequestParam(value="startDate") String startDate, @RequestParam(value="endDate") String endDate) throws Exception{
		return stockPriceService.companyStockPrice(companyName, startDate, endDate);
	}
}				