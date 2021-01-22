package org.einnovator.util.format;

import java.text.DateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class RichDateFormatterTests {

	@Test
	public void defaultStyleTest() {
		RichDateFormatter formatter = new RichDateFormatter();
		System.out.println("Default Style:");
		basicTests(formatter);
	}

	@Test
	public void shortStyleTest() {
		RichDateFormatter formatter = new RichDateFormatter(DateFormat.SHORT);
		System.out.println("Short Style:");
		basicTests(formatter);

	}


	public void basicTests(RichDateFormatter formatter) {
		System.out.println(formatter.print(new Date(), null));
		System.out.println(formatter.print(new Date(System.currentTimeMillis()-1000*60), null));
		System.out.println(formatter.print(new Date(System.currentTimeMillis()-1000*2*60), null));
		System.out.println(formatter.print(new Date(System.currentTimeMillis()-1000*60*60*(1+0)), null));
		System.out.println(formatter.print(new Date(System.currentTimeMillis()-1000*60*60*(2+0)), null));
		System.out.println(formatter.print(new Date(System.currentTimeMillis()-1000*60*60*24*(1+0)), null));
		System.out.println(formatter.print(new Date(System.currentTimeMillis()-1000*60*60*24*(2+0)), null));
	}

}
