package org.einnovator.util.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class RichDateFormatter implements Formatter<Date> {
	
	private SimpleDateFormat formater;
	
	public RichDateFormatter() {
		formater = new SimpleDateFormat("dd-MMM-yyy");
	}

	public RichDateFormatter(SimpleDateFormat formater) {
		this.formater = formater;
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
		if (days<7) {
			return (days==1 ? "yesterday" : days + " days ago");
		}
		return formater.format(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		throw new ParseException("Not Implemented!", 0);
	}

}
