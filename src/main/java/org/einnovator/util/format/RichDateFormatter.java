package org.einnovator.util.format;

import static org.einnovator.util.StringUtil.concat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.format.Formatter;

/**
 * A rich {@code DateFormatter}
 *
 * @author support@einnovator.org
 */
public class RichDateFormatter implements Formatter<Date> {

	public static final Integer DEFAULT_MAX_DAYS = 30;
	public static final Integer DEFAULT_SHORT_DAYS = null;

	public static final String KEY_NOW = "now";
	public static final String KEY_YESTERDAY = "yesterday";
	public static final String KEY_SEC = "sec";
	public static final String KEY_SECS = "secs";
	public static final String KEY_MIN = "min";
	public static final String KEY_MINS = "mins";
	public static final String KEY_HOUR = "hour";
	public static final String KEY_HOURS = "hours";
	public static final String KEY_DAY = "day";
	public static final String KEY_DAYS = "days";
	public static final String KEY_AGO = "ago";


	protected SimpleDateFormat formatter;
	
	protected Integer maxDays;
	
	protected int style;
	
	protected ResourceBundle bundle;
	
	protected boolean fallback;
		
	protected boolean seconds;

	protected boolean fraction;

	protected boolean now = true;

	public RichDateFormatter() {
		this(DateFormat.DEFAULT);
	}

	public RichDateFormatter(int style) {
		this(style, style==DateFormat.SHORT ? DEFAULT_SHORT_DAYS : DEFAULT_MAX_DAYS);
	}

	public RichDateFormatter(int style, Integer maxDays) {
		this(new SimpleDateFormat("dd MMM yyy"), style);
	}

	public RichDateFormatter(SimpleDateFormat formatter) {
		this(formatter, DateFormat.DEFAULT);
	}

	public RichDateFormatter(SimpleDateFormat formatter, int style) {
		this(formatter, style, style==DateFormat.SHORT ? DEFAULT_SHORT_DAYS : DEFAULT_MAX_DAYS);
	}

	public RichDateFormatter(SimpleDateFormat formatter, int style, Integer maxDays) {
		this.formatter = formatter;
		this.style = style;
		this.maxDays = maxDays;
	}

	/**
	 * Get the value of property {@code formatter}.
	 *
	 * @return the value of {@code formatter}
	 */
	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	/**
	 * Set the value of property {@code formatter}.
	 *
	 * @param formatter the value of {@code formatter}
	 */
	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

	/**
	 * Get the value of property {@code maxDays}.
	 *
	 * @return the value of {@code maxDays}
	 */
	public Integer getMaxDays() {
		return maxDays;
	}

	/**
	 * Set the value of property {@code maxDays}.
	 *
	 * @param maxDays the value of {@code maxDays}
	 */
	public void setMaxDays(Integer maxDays) {
		this.maxDays = maxDays;
	}

	/**
	 * Get the value of property {@code style}.
	 *
	 * @return the value of {@code style}
	 */
	public int getStyle() {
		return style;
	}

	/**
	 * Set the value of property {@code style}.
	 *
	 * @param style the value of {@code style}
	 */
	public void setStyle(int style) {
		this.style = style;
	}

	/**
	 * Get the value of property {@code now}.
	 *
	 * @return the value of {@code now}
	 */
	public boolean isNow() {
		return now;
	}

	/**
	 * Set the value of property {@code now}.
	 *
	 * @param now the value of {@code now}
	 */
	public void setNow(boolean now) {
		this.now = now;
	}

	/**
	 * Get the value of property {@code fallback}.
	 *
	 * @return the value of {@code fallback}
	 */
	public boolean isFallback() {
		return fallback;
	}

	/**
	 * Set the value of property {@code fallback}.
	 *
	 * @param fallback the value of {@code fallback}
	 */
	public void setFallback(boolean fallback) {
		this.fallback = fallback;
	}

	/**
	 * Get the value of property {@code fraction}.
	 *
	 * @return the value of {@code fraction}
	 */
	public boolean isFraction() {
		return fraction;
	}

	/**
	 * Set the value of property {@code fraction}.
	 *
	 * @param fraction the value of {@code fraction}
	 */
	public void setFraction(boolean fraction) {
		this.fraction = fraction;
	}

	/**
	 * Get the value of property {@code seconds}.
	 *
	 * @return the value of {@code seconds}
	 */
	public boolean isSeconds() {
		return seconds;
	}

	/**
	 * Set the value of property {@code seconds}.
	 *
	 * @param seconds the value of {@code seconds}
	 */
	public void setSeconds(boolean seconds) {
		this.seconds = seconds;
	}

	@Override
	public String print(Date date, Locale locale) {
		long sec = getDurationSeconds(date);
		if (seconds) {
			if (sec==0 && isNow()) {
				return resolve(KEY_NOW);
			}
			if (sec < 60) {
				return concat(getSeparator(), sec, resolve(sec==1 ? KEY_SEC: KEY_SECS), resolve(KEY_AGO));
			}			
		}
		long min = sec/60;
		if (min==0 && isNow()) {
			return resolve(KEY_NOW);
		}
		if (min < 60) {
			if (fraction) {
				long sec_ = sec - min*60;
				if (sec_>0) {
					String fsec = Long.toString(sec_);
					return concat(getSeparator(), min, resolve(min==1 ? KEY_MIN: KEY_MINS), fsec, resolve(sec_==1 ? KEY_SEC: KEY_SECS), resolve(KEY_AGO));									
				}
			}
			return concat(getSeparator(), min, resolve(min==1 ? KEY_MIN: KEY_MINS), resolve(KEY_AGO));				
		}
		long hs = min / 60;
		if (hs<24) {
			if (fraction) {
				long min_ = min - hs*60;
				if (min_>0) {
					String fmin = Long.toString(min_);
					return concat(getSeparator(), hs, resolve(hs==1 ? KEY_HOUR: KEY_HOURS), fmin, resolve(min_==1 ? KEY_MIN: KEY_MINS), resolve(KEY_AGO));
				}
			}
			return concat(getSeparator(), hs, resolve(hs==1 ? KEY_HOUR: KEY_HOURS), resolve(KEY_AGO));
		}
		long days = min / (60*24);
		if (days==1 && now) {
			return resolve(KEY_YESTERDAY);
		}
		if (formatter==null || maxDays==null || days<maxDays) {
			if (fraction) {
				long hs_ = hs - days*24;
				if (hs_>0) {
					String fhs = Long.toString(hs_);
					return concat(getSeparator(), days, resolve(days==1 ? KEY_DAY: KEY_DAYS), fhs, resolve(hs_==1 ? KEY_HOUR: KEY_HOURS), resolve(KEY_AGO));
				}
			}
			return concat(getSeparator(), days, resolve(days==1 ? KEY_DAY: KEY_DAYS), resolve(KEY_AGO));
		}
		return formatter.format(date);
	}

	protected long getDurationSeconds(Date date) {
		return (System.currentTimeMillis() - date.getTime())/(1000);
	}
	protected String resolve(String key) {
		return resolve(key, style);
	}

	protected String resolve(String key, int style) {
		if (bundle!=null) {
			String prefix = getStylePrefix(style);
			if (prefix!=null && !prefix.isEmpty()) {
				key = prefix + key;
			}
			if (!fallback) {
				return resolveExternal(key);
			}
			String s = resolveExternal(key, false);
			if (s!=null && !s.isEmpty()) {
				return s;
			}
		}
		return resolveInternal(key, style);
	}
	
	protected String resolveInternal(String key, int style) {
		switch (style) {
		case DateFormat.SHORT:
			return resolveShort(key);
		case DateFormat.DEFAULT:
		default:
			return resolveDefault(key);
		}
	}

	protected String getStylePrefix(int style) {
		switch (style) {
		case DateFormat.SHORT:
			return "short.";
		case DateFormat.DEFAULT:
		default:
			return "";
		}
	}

	protected String getSeparator() {
		return getSeparator(style);
	}
	
	protected String getSeparator(int style) {
		switch (style) {
		case DateFormat.SHORT:
			return "";
		case DateFormat.DEFAULT:
		default:
			return " ";
		}
	}
	protected String resolveDefault(String key) {
		switch (key) {
		case KEY_NOW:
			return "just now";
		case KEY_YESTERDAY:
			return "yesterday";
		case KEY_SEC:
			return "sec";
		case KEY_SECS:
			return "secs";
		case KEY_MIN:
			return "min";
		case KEY_MINS:
			return "mins";
		case KEY_HOUR:
			return "hour";
		case KEY_HOURS:
			return "hours";
		case KEY_DAY:
			return "day";
		case KEY_DAYS:
			return "days";
		case KEY_AGO:
			return "ago";			
		}
		return "";
	}

	protected String resolveShort(String key) {
		switch (key) {
		case KEY_NOW:
			return "now";
		case KEY_YESTERDAY:
			return "1d";
		case KEY_SEC:
		case KEY_SECS:
			return "s";
		case KEY_MIN:
		case KEY_MINS:
			return "m";
		case KEY_HOUR:
		case KEY_HOURS:
			return "h";
		case KEY_DAY:
		case KEY_DAYS:
			return "d";
		case KEY_AGO:
			return "";		
		}
		return resolveDefault(key);		
	}

	protected String resolveExternal(String key) {
		return resolveExternal(key, true);
	}
	
	public String resolveExternal(String key, boolean required) {
		return resolve(key, required ? "?" + key + "?" : null);
	}
	
	public String resolve(String key, String defaultValue) {
		if (bundle!=null) {
			try {
				return bundle.getString(key);	
			} catch (RuntimeException e) {
			}			
		}
		return defaultValue;
	}
	
	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		throw new ParseException("Not Implemented!", 0);
	}

}
