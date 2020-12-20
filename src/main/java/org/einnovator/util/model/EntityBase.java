package org.einnovator.util.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class EntityBase extends ObjectBase {

	protected String id;
	
	protected String uuid;
	
	protected Date creationDate;

	protected Date lastModified;
	
	protected String creationDateFormatted;

	protected String lastModifiedFormatted;
	
	protected String createdBy;
	
	protected String lastModifiedBy;
	
	protected Object lastModifiedByUser;

	protected Object createdByUser;
	

	/**
	 * Create instance of {@code EntityBase}.
	 *
	 */
	public EntityBase() {
	}

	/**
	 * Create instance of {@code EntityBase}.
	 *
	 * @param obj a prototype
	 */
	public EntityBase(Object obj) {
		updateFrom(obj, false);
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
	 * @param id the value of property id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the value of property {@code uuid}.
	 *
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Set the value of property {@code uuid}.
	 *
	 * @param uuid the value of property uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Get the value of property {@code creationDate}.
	 *
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Set the value of property {@code creationDate}.
	 *
	 * @param creationDate the value of property creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Get the value of property {@code lastModified}.
	 *
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * Set the value of property {@code lastModified}.
	 *
	 * @param lastModified the value of property lastModified
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * Get the value of property {@code creationDateFormatted}.
	 *
	 * @return the creationDateFormatted
	 */
	public String getCreationDateFormatted() {
		return creationDateFormatted;
	}

	/**
	 * Set the value of property {@code creationDateFormatted}.
	 *
	 * @param creationDateFormatted the value of property creationDateFormatted
	 */
	public void setCreationDateFormatted(String creationDateFormatted) {
		this.creationDateFormatted = creationDateFormatted;
	}

	/**
	 * Get the value of property {@code lastModifiedFormatted}.
	 *
	 * @return the lastModifiedFormatted
	 */
	public String getLastModifiedFormatted() {
		return lastModifiedFormatted;
	}

	/**
	 * Set the value of property {@code lastModifiedFormatted}.
	 *
	 * @param lastModifiedFormatted the value of property lastModifiedFormatted
	 */
	public void setLastModifiedFormatted(String lastModifiedFormatted) {
		this.lastModifiedFormatted = lastModifiedFormatted;
	}

	/**
	 * Get the value of property {@code createdBy}.
	 *
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Set the value of property {@code createdBy}.
	 *
	 * @param createdBy the value of property createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Get the value of property {@code lastModifiedBy}.
	 *
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * Set the value of property {@code lastModifiedBy}.
	 *
	 * @param lastModifiedBy the value of property lastModifiedBy
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	
	/**
	 * Get the value of property {@code lastModifiedByUser}.
	 *
	 * @return the lastModifiedByUser
	 */
	public Object getLastModifiedByUser() {
		return lastModifiedByUser;
	}

	/**
	 * Set the value of property {@code lastModifiedByUser}.
	 *
	 * @param lastModifiedByUser the value of property lastModifiedByUser
	 */
	public void setLastModifiedByUser(Object lastModifiedByUser) {
		this.lastModifiedByUser = lastModifiedByUser;
	}

	/**
	 * Get the value of property {@code createdByUser}.
	 *
	 * @return the createdByUser
	 */
	public Object getCreatedByUser() {
		return createdByUser;
	}

	/**
	 * Set the value of property {@code createdByUser}.
	 *
	 * @param createdByUser the value of property createdByUser
	 */
	public void setCreatedByUser(Object createdByUser) {
		this.createdByUser = createdByUser;
	}

	//
	// With
	//
	
	/**
	 * Set the value of property {@code id}.
	 *
	 * @param id the value of property id
	 * @return this {@code EntityBase}
	 */
	public EntityBase withId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Set the value of property {@code uuid}.
	 *
	 * @param uuid the value of property uuid
	 * @return this {@code EntityBase}
	 */
	public EntityBase withUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * Set the value of property {@code creationDate}.
	 *
	 * @param creationDate the value of property creationDate
	 * @return this {@code EntityBase}
	 * @return this {@code EntityBase}
	 */
	public EntityBase withCreationDate(Date creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	/**
	 * Set the value of property {@code lastModified}.
	 *
	 * @param lastModified the value of property lastModified
	 * @return this {@code EntityBase}
	 * @return this {@code EntityBase}
	 */
	public EntityBase withLastModified(Date lastModified) {
		this.lastModified = lastModified;
		return this;
	}

	/**
	 * Set the value of property {@code creationDateFormatted}.
	 *
	 * @param creationDateFormatted the value of property creationDateFormatted
	 * @return this {@code EntityBase}
	 */
	public EntityBase withCreationDateFormatted(String creationDateFormatted) {
		this.creationDateFormatted = creationDateFormatted;
		return this;
	}

	/**
	 * Set the value of property {@code lastModifiedFormatted}.
	 *
	 * @param lastModifiedFormatted the value of property lastModifiedFormatted
	 * @return this {@code EntityBase}
	 */
	public EntityBase withLastModifiedFormatted(String lastModifiedFormatted) {
		this.lastModifiedFormatted = lastModifiedFormatted;
		return this;
	}

	/**
	 * Set the value of property {@code createdBy}.
	 *
	 * @param createdBy the value of property createdBy
	 * @return this {@code EntityBase}
	 */
	public EntityBase withCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	/**
	 * Set the value of property {@code lastModifiedBy}.
	 *
	 * @param lastModifiedBy the value of property lastModifiedBy
	 * @return this {@code EntityBase}
	 */
	public EntityBase withLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
		return this;
	}

	/**
	 * Set the value of property {@code lastModifiedByUser}.
	 *
	 * @param lastModifiedByUser the value of property lastModifiedByUser
	 * @return this {@code EntityBase}
	 */
	public EntityBase withLastModifiedByUser(Object lastModifiedByUser) {
		this.lastModifiedByUser = lastModifiedByUser;
		return this;
	}

	/**
	 * Set the value of property {@code createdByUser}.
	 *
	 * @param createdByUser the value of property createdByUser
	 * @return this {@code EntityBase}
	 */
	public EntityBase withCreatedByUser(Object createdByUser) {
		this.createdByUser = createdByUser;
		return this;
	}


	@Override
	public ToStringCreator toString0(ToStringCreator creator) {
		return creator
				.append("id", id)
				.append("uuid", uuid);
	}
	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return creator
				.append("lastModified", lastModified)
				.append("creationDate", creationDate)
				.append("lastModifiedFormatted", lastModifiedFormatted)
				.append("creationDateFormatted", creationDateFormatted)
				.append("lastModifiedBy", lastModifiedBy)
				.append("createdBy", createdBy)
				;
	}

	public static <T extends EntityBase> T findById(String id, Iterable<T> it) {
		if (it!=null) {
			for (T obj: it) {
				if (id.equals(obj.getId())) {
					return obj;
				}
			}			
		}
		return null;
	}

	public static <T extends EntityBase> T findByUuid(String uuid, Iterable<T> it) {
		if (uuid!=null && it!=null) {
			for (T obj: it) {
				if (uuid.equals(obj.getUuid())) {
					return obj;
				}
			}			
		}
		return null;
	}

	public static <T extends EntityBase> List<String> getIds(Iterable<T> it) {
		if (it==null) {
			return null;
		}
		List<String> ids = new ArrayList<>();
		for (EntityBase obj: it) {
			if (obj.getId()!=null) {
				ids.add(obj.getId());				
			}
		}
		return ids;
	}

	public static <T extends EntityBase> List<String> getUuids(Iterable<T> it) {
		if (it==null) {
			return null;
		}
		List<String> ids = new ArrayList<>();
		for (EntityBase obj: it) {
			if (obj.getUuid()!=null) {
				ids.add(obj.getUuid());				
			}
		}
		return ids;
	}
}
