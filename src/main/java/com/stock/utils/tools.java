package com.stock.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class tools {

	public static void main(String[] args) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss");
		DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		Timestamp t1 = Timestamp.valueOf(sdf2.format(sdf.parse(String.valueOf("08-六月-2019") + String.valueOf("  10:30:00"))));
		System.out.println(t1);
		//System.out.println(Timestamp.valueOf(String.valueOf("2019-6-8") + String.valueOf("10:30:00")));
	}

}
