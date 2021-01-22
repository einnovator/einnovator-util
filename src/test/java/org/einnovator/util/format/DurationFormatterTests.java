package org.einnovator.util.format;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class DurationFormatterTests {


	@Test
	public void durationTest() {
		DurationFormatter formatter = new DurationFormatter();
		System.out.println(formatter.print(new Date(0), null));
		System.out.println(formatter.print(new Date(1000*10), null));
		System.out.println(formatter.print(new Date(1000*60), null));
		System.out.println(formatter.print(new Date(1000*100), null));
		System.out.println(formatter.print(new Date(1000*600), null));
		System.out.println(formatter.print(new Date(1000*1000), null));
		System.out.println(formatter.print(new Date(1000*6000), null));
		System.out.println(formatter.print(new Date(1000*10000), null));
	}

	
}
