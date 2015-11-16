package base.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DateAndTimeUtil {
    public static String getAmPm(int hour, int minus) {
        String minStr = "";
        if (minus < 10) {
            minStr = "0" + minus;
        } else {
            minStr = "" + minus;
        }

        if (hour > 12) {
            return (hour - 12) + ":" + minStr + " " + "PM";
        } else {
            return (hour) + ":" + minStr + " " + "AM";
        }
    }

    public static String getDateToString(int day, int month, int year) {
        String monthStr = "";
        monthStr = getMonthName(month);
        return day + "-" + monthStr + "-" + year;
    }

    private static String getMonthName(int month) {
        String monthStr = "";
        switch (++month) {
            case 1:
                monthStr = "JAN";
                break;
            case 2:
                monthStr = "FEB";
                break;
            case 3:
                monthStr = "MAR";
                break;
            case 4:
                monthStr = "APR";
                break;
            case 5:
                monthStr = "MAY";
                break;
            case 6:
                monthStr = "JUN";
                break;
            case 7:
                monthStr = "JUL";
                break;
            case 8:
                monthStr = "AUG";
                break;
            case 9:
                monthStr = "SEP";
                break;
            case 10:
                monthStr = "OCT";
                break;
            case 11:
                monthStr = "NAV";
                break;
            case 12:
                monthStr = "DEC";
                break;

        }
        return monthStr;
    }

 public static HashMap<String,Integer> parseDateToint(String date)
 {
     StringTokenizer stringTokenizer = new StringTokenizer(date, "-");
     HashMap<String,Integer> dateMap = new HashMap<>();
     String year = "2013", month = "0", day = "21";
     int yearInt,monthInt,dayInt;
     if (stringTokenizer.hasMoreElements()) {
         year = stringTokenizer.nextToken();
     }
     if (stringTokenizer.hasMoreElements()) {
         month = stringTokenizer.nextToken();
     }
     if (stringTokenizer.hasMoreElements()) {
         day = stringTokenizer.nextToken();
     }
     try {
        monthInt = Integer.parseInt(month);
         dayInt = Integer.parseInt(day);
         yearInt = Integer.parseInt(year);
     }
     catch (NumberFormatException e)
     {
         monthInt = 5;
         dayInt = 20;
         yearInt =2015;
     }
     dateMap.put("DAY",dayInt);
     dateMap.put("MONTH",monthInt);
     dateMap.put("YEAR",yearInt);
     return dateMap;

 }
    public static String changeYyMmDdToDdMmYy(String date) {

        StringTokenizer stringTokenizer = new StringTokenizer(date, "-");
        String year = "2013", month = "0", day = "21";
        if (stringTokenizer.hasMoreElements()) {
            year = stringTokenizer.nextToken();
        }
        if (stringTokenizer.hasMoreElements()) {
            month = stringTokenizer.nextToken();
        }
        if (stringTokenizer.hasMoreElements()) {
            day = stringTokenizer.nextToken();
        }
        int monthInt = Integer.parseInt(month);
        month = getMonthName(monthInt - 1);
        return day + "-" + month + "-" + year;
    }

    public static String getPresentDate() {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        if ((month + 1) < 10) {
            return day + "-0" + (month + 1) + "-" + year;
        }
        if (day < 10) {
            return "0" + day + "-" + (month + 1) + "-" + year;
        }
        return day + "-" + (month + 1) + "-" + year;
    }
}
