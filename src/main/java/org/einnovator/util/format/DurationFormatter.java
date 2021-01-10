package org.einnovator.util.format;

import java.text.DateFormat;
import java.util.Date;

/**
 * A duration {@code Formatter}
 *
 * @author support@einnovator.org
 */
public class DurationFormatter extends RichDateFormatter {

	public DurationFormatter() {
		super(DateFormat.SHORT);
		now = false;
		fraction = true;
		seconds = true;
	}

	protected long getDurationSeconds(Date date) {
		return (date.getTime())/(1000);
	}
}
