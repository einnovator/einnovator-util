/**
 * 
 */
package org.einnovator.util;

import static org.junit.jupiter.api.Assertions.*;

import static org.einnovator.util.UriUtils.*;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class UriUtilsTests {

	@Test
	public void domainTests() {
		String uri="https://index.docker.io/v1/";
		assertEquals("index.docker.io", getHost(uri));
		assertEquals("docker.io", getDomain(uri));
		assertEquals("docker", getProperDomain(uri));

		uri="https://products.shop.co.uk/v1/";
		assertEquals("products.shop.co.uk", getHost(uri));
		assertEquals("shop.co.uk", getDomain(uri));
		assertEquals("shop", getProperDomain(uri));

	}

}
