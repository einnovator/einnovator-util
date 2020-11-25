package org.einnovator.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Miscellaneous utility methods related with {@code Date}.
 *
 * @author support@einnovator.org {@code support@einnovator.org}
 *
 */
public class DateUtil {
	
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static int diffMillis(Date date, Date date2) {
		Calendar a = Calendar.getInstance();
		a.setTime(date);
		Calendar b = Calendar.getInstance();
		b.setTime(date2);
		return a.compareTo(b);
	}

	public static int diffSec(Date date, Date date2) {
		return diffMillis(date, date2) / (1000);
	}
	
	public static int diffMin(Date date, Date date2) {
		return diffMillis(date, date2) / (1000*60);
	}

	public static int diffHour(Date date, Date date2) {
		return diffMillis(date, date2) / (1000*3600);
	}
	
	public static int diffDay(Date date, Date date2) {
		return diffMillis(date, date2) / (1000*24*3600);
	}
	
	public static boolean sameDate(Date date, Date date2) {
		if(date==null && date2==null){
			return true;
		}
		else if(date==null || date2==null){
			return false;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		TimeZone tz = TimeZone.getDefault();
		calendar.setTimeZone(tz);
		

		Calendar anotherCalendar = Calendar.getInstance();
		anotherCalendar.setTime(date2);
		anotherCalendar.set(Calendar.HOUR_OF_DAY, 0);
		anotherCalendar.set(Calendar.MINUTE, 0);
		anotherCalendar.set(Calendar.SECOND, 0);
		anotherCalendar.set(Calendar.MILLISECOND, 0);
		anotherCalendar.setTimeZone(tz);
		return calendar.compareTo(anotherCalendar) == 0;
	}
}
