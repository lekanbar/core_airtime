package com.core.airtime;

import java.util.Calendar;

public class UniqueID {
	public static String GetUniqueID(String phoneNumber){
    	Calendar c = Calendar.getInstance();
    	String hour = (String.valueOf(c.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) : String.valueOf(c.get(Calendar.HOUR_OF_DAY))); 
    	String minute = (String.valueOf(c.get(Calendar.MINUTE)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.MINUTE)) : String.valueOf(c.get(Calendar.MINUTE)));
    	
    	int len = phoneNumber.length();
    	String ph = phoneNumber.substring(1, len);
    	if(ph.length() == 7) ph += "000";
    	else if(ph.length() == 8) ph += "00";
    	else if(ph.length() == 9) ph += "0";
    	
    	String uniqueID = hour + minute + ph +
    			          computeTotalDays(c.get(Calendar.DATE), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
    	return uniqueID;
    }
	
	public static String computeTotalDays(int day, int month, int year){
        int daysPassed = 0;
        
        for(int i = 1; i < month; i++)
        {
            daysPassed += daysInMonth(day,i,year);
        }
        
        String ret = String.valueOf(daysPassed + day + 1);
        
        if(ret.length() == 2)
        	ret = "0" + ret;
        
        return ret;
	}
	
	public static int daysInMonth(int day, int month, int year){
	
	    if ( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
	        return 31;
	
	    if ( month == 4 || month == 6 || month == 9 || month == 11 )
	        return 30;
	
	    if ( month == 2 ) return isLeapYear(year) ? 29 : 28;
	
	    return 0;
	}
	
	public static boolean isLeapYear(int year) {    	
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, year);
	    return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	}
}
