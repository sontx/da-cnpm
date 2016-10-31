package com.dutproject.cinemaproject.utils.schedule;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
	public static Date stringToDate(String s) {
		DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy"); 
	    Date date = null;
	    try {
	        date = df.parse(s);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return date;
	}
	
	public static int dateToInt(Date date) {
		int value;
		value = (int) (date.getTime() / 1000);
		return value;
	}
	
	public static Date intToDate(int i) {
		Date date = new Date(((long)i) * 1000L);
		return date;
	}
	
}
