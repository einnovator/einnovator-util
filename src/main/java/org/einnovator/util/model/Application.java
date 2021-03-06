package org.einnovator.util.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Application extends ObjectBase {

	private String id;

	private String name;

	private String icon;

	private String img;
	
	private String thumbnail;
	
	private String info;
	
	private String description;

	
	/**
	 * Create instance of {@code Application}.
	 *
	 */
	public Application() {
	}


	/**
	 * Create instance of {@code Application}.
	 *
	 * @param obj a prototype
	 */
	public Application(Object obj) {
		super(obj);
	}


	/**
	 * Get the value of property {@code id}.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * Set the value of property {@code id}.
	 *
	 * @param id the id
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Get the value of property {@code icon}.
	 *
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}


	/**
	 * Set the value of property {@code icon}.
	 *
	 * @param icon the icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}


	/**
	 * Get the value of property {@code img}.
	 *
	 * @return the img
	 */
	public String getImg() {
		return img;
	}


	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the img
	 */
	public void setImg(String img) {
		this.img = img;
	}
	
	/**
	 * Get the value of property {@code info}.
	 *
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}


	/**
	 * Set the value of property {@code info}.
	 *
	 * @param info the info
	 */
	public void setInfo(String info) {
		this.info = info;
	}


	/**
	 * Get the value of property {@code description}.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * Get the value of property {@code thumbnail}.
	 *
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * Set the value of property {@code thumbnail}.
	 *
	 * @param thumbnail the thumbnail
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public ToStringCreator toString0(ToStringCreator creator) {
		return creator
				.append("id", id)
				.append("name", name)
				.append("icon", icon)
				.append("info", info)
				.append("img", img)
				.append("thumbnail", thumbnail)
				;
	}
	

}