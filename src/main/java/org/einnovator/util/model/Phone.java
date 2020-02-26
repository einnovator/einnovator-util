package org.einnovator.util.model;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Phone extends ObjectBase {

	protected String number;

	protected String area;

	protected String countryCode;

	protected String country;

	/**
	 * Create instance of {@code Phone}.
	 *
	 */
	public Phone() {
	}

	/**
	 * Create instance of {@code Phone}.
	 *
	 * @param obj a prototype
	 */
	public Phone(Object obj) {
		super(obj);
	}
	
	/**
	 * Get the value of property {@code number}.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Set the value of property {@code number}.
	 *
	 * @param number the value of property number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Get the value of property {@code area}.
	 *
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Set the value of property {@code area}.
	 *
	 * @param area the value of property area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Get the value of property {@code countryCode}.
	 *
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Set the value of property {@code countryCode}.
	 *
	 * @param countryCode the value of property countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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
	 * Create instance of {@code Phone}.
	 *
	 * @param number the number
	 */
	public Phone(String number) {
		this.number = number;
	}

	
	/**
	 * Set the value of property {@code number}.
	 *
	 * @param number the value of property number
	 * @return this {@code Phone}
	 */
	public Phone withNumber(String number) {
		this.number = number;
		return this;
	}

	/**
	 * Set the value of property {@code area}.
	 *
	 * @param area the value of property area
	 * @return this {@code Phone}
	 */
	public Phone withArea(String area) {
		this.area = area;
		return this;
	}

	/**
	 * Set the value of property {@code countryCode}.
	 *
	 * @param countryCode the value of property countryCode
	 * @return this {@code Phone}
	 */
	public Phone withCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	/**
	 * Set the value of property {@code country}.
	 *
	 * @param country the value of property country
	 * @return this {@code Phone}
	 */
	public Phone withCountry(String country) {
		this.country = country;
		return this;
	}

	@Override
	public ToStringCreator toString0(ToStringCreator builder) {
		return builder
			.append("number", number)
			.append("area", area)
			.append("countryCode", countryCode)
			.append("country", country);
	}
	
	@JsonIgnore
	public boolean isEmpty() {
		return !StringUtils.hasText(country) &&
				!StringUtils.hasText(countryCode) &&
				!StringUtils.hasText(number) && 
				!StringUtils.hasText(area);
	}

	public String getFormatted() {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.hasText(countryCode)) {
			if (!countryCode.trim().startsWith("+")) {
				sb.append("+");
			}
			sb.append(countryCode);
		}
		if (StringUtils.hasText(area)) {
			if (sb.length()!=0) {
				sb.append(" ");
			}
			sb.append("(");
			sb.append(area);
			sb.append(")");
		}

		if (StringUtils.hasText(number)) {
			if (sb.length()!=0) {
				sb.append(" ");
			}
			sb.append(number);
		}

		return sb.toString();
	}

	
}
