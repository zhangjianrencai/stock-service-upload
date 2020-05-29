package com.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stock.entity.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
	
	@Query(value = "select c.company_name , sp.date_time, sp.current_price from company c right join stock_price sp on c.stock_code = sp.stock_code "
			+ "where c.company_name like ? and sp.date_time between ? AND ?;",nativeQuery = true)
	public List<Object[]> companyStockPrice(@Param("companyName")String companyName, @Param("startDate")String startDate,  @Param("endDate")String endDate);

}