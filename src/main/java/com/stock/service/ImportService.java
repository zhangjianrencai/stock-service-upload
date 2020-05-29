package com.stock.service;

import java.io.InputStream;
import java.util.List;

public interface ImportService {


    /**
     * 处理上传的文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public List getBankListByExcel(InputStream in, String fileName) throws Exception;
}
