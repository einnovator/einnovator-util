package org.einnovator.util.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class RichDateFormatter implements Formatter<Date> {
	
	private SimpleDateFormat formatter;
	
	private Integer maxDays = 30;
	
	public RichDateFormatter() {
		formatter = new SimpleDateFormat("dd MMM yyy");
	}

	public RichDateFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

	@Override
	public String print(Date date, Locale locale) {
		long dt = (System.currentTimeMillis() - date.getTime())/(1000*60);
		if (dt==0) {
			return "just now";
		}
		if (dt < 60) {
			return dt + " mins ago";
		}
		long hs = dt / 60;
		if (hs<24) {
			return hs + (hs==1 ? " hour" : " hours") + " ago";
		}
		long days = dt / (60*24);
		if (days==1) {
			return "yesterday";
		}
		if (maxDays!=null && days<maxDays) {
			return days + " days ago";
		}
		if (formatter==null) {
			return null;
		}
		return formatter.format(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		throw new ParseException("Not Implemented!", 0);
	}

}
