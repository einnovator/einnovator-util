package org.einnovator.util.model;


import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends ObjectBase {
	
	private String country;
	
	private String countryCode2;

	private String countryCode3;
	
	private String postalCode;
	
	private String city;
	
	private String line1;

	private String line2;

	private String state;

	private String locality;

	private String latitude;
	
	private String longitude;

	/**
	 * Create instance of {@code Address}.
	 *
	 */
	public Address() {
	}
	
	/**
	 * Create instance of {@code Address}.
	 *
	 * @param country the country
	 * @param state sthe tate
	 */
	public Address(String country, String state) {
		this.country = country;
		this.state = state;
	}


	/**
	 * Create instance of {@code Address}.
	 *
	 * @param obj a prototype
	 */
	public Address(Object obj) {
		updateFrom(obj);			
	}

	/**
	 * Create instance of {@code Address}.
	 *
	 * @param country the country
	 * @param postalCode the postalCode
	 * @param city the city
	 * @param line1 the line1
	 * @param line2 the line2
	 * @param state the state
	 * @param locality the locality 
	 */
	public Address(String country, String postalCode, String city, String line1, String line2, String state, String locality) {
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
		this.line1 = line1;
		this.line2 = line2;
		this.state = state;
		this.locality = locality;
		this.locality = locality;
	}
	
	/**
	 * Get the value of property {@code country}.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set the value of property {@code country}.
	 *
	 * @param country the value of property country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get the value of property {@code countryCode2}.
	 *
	 * @return the countryCode2
	 */
	public String getCountryCode2() {
		return countryCode2;
	}

	/**
	 * Set the value of property {@code countryCode2}.
	 *
	 * @param countryCode2 the value of property countryCode2
	 */
	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	/**
	 * Get the value of property {@code countryCode3}.
	 *
	 * @return the countryCode3
	 */
	public String getCountryCode3() {
		return countryCode3;
	}

	/**
	 * Set the value of property {@code countryCode3}.
	 *
	 * @param countryCode3 the value of property countryCode3
	 */
	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}

	/**
	 * Get the value of property {@code postalCode}.
	 *
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Set the value of property {@code postalCode}.
	 *
	 * @param postalCode the value of property postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Get the value of property {@code city}.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the value of property {@code city}.
	 *
	 * @param city the value of property city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the value of property {@code line1}.
	 *
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * Set the value of property {@code line1}.
	 *
	 * @param line1 the value of property line1
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * Get the value of property {@code line2}.
	 *
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * Set the value of property {@code line2}.
	 *
	 * @param line2 the value of property line2
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * Get the value of property {@code state}.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the value of property {@code state}.
	 *
	 * @param state the value of property state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Get the value of property {@code locality}.
	 *
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * Set the value of property {@code locality}.
	 *
	 * @param locality the value of property locality
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * Get the value of property {@code latitude}.
	 *
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Set the value of property {@code latitude}.
	 *
	 * @param latitude the value of property latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Get the value of property {@code longitude}.
	 *
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Set the value of property {@code longitude}.
	 *
	 * @param longitude the value of property longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	// With

	/**
	 * Set the value of property {@code country}.
	 *
	 * @param country the value of property country
	 */
	public Address withCountry(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Set the value of property {@code countryCode2}.
	 *
	 * @param countryCode2 the value of property countryCode2
	 */
	public Address withCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
		return this;
	}

	/**
	 * Set the value of property {@code countryCode3}.
	 *
	 * @param countryCode3 the value of property countryCode3
	 */
	public Address withCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
		return this;
	}

	/**
	 * Set the value of property {@code postalCode}.
	 *
	 * @param postalCode the value of property postalCode
	 */
	public Address withPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	/**
	 * Set the value of property {@code city}.
	 *
	 * @param city the value of property city
	 */
	public Address withCity(String city) {
		this.city = city;
		return this;
	}

	/**
	 * Set the value of property {@code line1}.
	 *
	 * @param line1 the value of property line1
	 */
	public Address withLine1(String line1) {
		this.line1 = line1;
		return this;
	}

	/**
	 * Set the value of property {@code line2}.
	 *
	 * @param line2 the value of property line2
	 */
	public Address withLine2(String line2) {
		this.line2 = line2;
		return this;
	}

	/**
	 * Set the value of property {@code state}.
	 *
	 * @param state the value of property state
	 */
	public Address withState(String state) {
		this.state = state;
		return this;
	}

	/**
	 * Set the value of property {@code locality}.
	 *
	 * @param locality the value of property locality
	 */
	public Address withLocality(String locality) {
		this.locality = locality;
		return this;
	}

	/**
	 * Set the value of property {@code latitude}.
	 *
	 * @param latitude the value of property latitude
	 */
	public Address withLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}

	/**
	 * Set the value of property {@code longitude}.
	 *
	 * @param longitude the value of property longitude
	 */
	public Address withLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}

	@Override
	public ToStringCreator toString0(ToStringCreator builder) {
		return builder
			.append("country", country)
			.append("countryCode2", countryCode2)
			.append("countryCode3", countryCode3)
			.append("postalCode", postalCode)
			.append("state", state)
			.append("city", city)
			.append("locality", locality)
			.append("line1", line1)
			.append("line2", line2)
			.append("latitude", latitude)
			.append("longitude", longitude);
	}

	@JsonIgnore
	public boolean isEmpty() {
		return !StringUtils.hasText(country) && !StringUtils.hasText(postalCode) && 
				!StringUtils.hasText(city) && !StringUtils.hasText(line1) && 
				!StringUtils.hasText(line2) && !StringUtils.hasText(state) &&
				!StringUtils.hasText(locality) &&
				!StringUtils.hasText(countryCode2) && !StringUtils.hasText(countryCode3) &&
				!StringUtils.hasText(latitude) && !StringUtils.hasText(longitude);
	}

	public String getFormatted() {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.hasText(city)) {
			sb.append(city);
		}
		if (StringUtils.hasText(state)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(state);
		}
		if (StringUtils.hasText(country)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(country);
		}
		return sb.toString();
	}

	public String getFormatted1() {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.hasText(line1)) {
			sb.append(line1.trim());
		}
		if (StringUtils.hasText(line2)) {
			if (sb.length()!=0) {
				if (!sb.toString().endsWith(",")) {
					sb.append(",");
				} else {
					sb.append(" ");
				}
			}
			sb.append(line2);
		}

		if (StringUtils.hasText(city)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(city.trim());
		}
		if (StringUtils.hasText(postalCode)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(postalCode.trim());
		}

		if (StringUtils.hasText(state)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(state.trim());
		}
		if (StringUtils.hasText(country)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(country.trim());
		}
		return sb.toString();
	}

	public String getFormatted2() {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.hasText(line1)) {
			sb.append(line1);
		}
		if (StringUtils.hasText(line2)) {
			if (sb.length()!=0) {
				sb.append(" ");
			}
			sb.append(line2);
		}

		if (StringUtils.hasText(city)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(city);
		}
		if (StringUtils.hasText(state)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(state);
		}
		if (StringUtils.hasText(country)) {
			if (sb.length()!=0) {
				sb.append(", ");
			}
			sb.append(country);
		}
		return sb.toString();
	}

}
