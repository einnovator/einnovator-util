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
	
	private String createdBy;
	
	private String lastModifiedBy;

	public EntityBase() {
	}

	public EntityBase(Object obj) {
		updateFrom(obj, false);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public ToStringCreator toString0(ToStringCreator creator) {
		return creator
				.append("id", id)
				.append("uuid", uuid);
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
	 * @param creationDateFormatted the creationDateFormatted to set
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
	 * @param lastModifiedFormatted the lastModifiedFormatted to set
	 */
	public void setLastModifiedFormatted(String lastModifiedFormatted) {
		this.lastModifiedFormatted = lastModifiedFormatted;
	}

	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return creator
				.append("lastModified", lastModified)
				.append("creationDate", creationDate)
				.append("lastModifiedFormatted", lastModifiedFormatted)
				.append("creationDateFormatted", creationDateFormatted)
				.append("lastModifiedBy", lastModifiedBy)
				.append("creationDateBy", createdBy)
				;
	}

	public static <T extends EntityBase> boolean findById(String id, Iterable<T> it) {
		if (it!=null) {
			for (T obj: it) {
				if (id.equals(obj.getId())) {
					return true;
				}
			}			
		}
		return false;
	}

	public static <T extends EntityBase> boolean findByUuid(String uuid, Iterable<T> it) {
		if (it!=null) {
			for (T obj: it) {
				if (uuid.equals(obj.getId())) {
					return true;
				}
			}			
		}
		return false;
	}

	public static <T extends EntityBase> List<String> getIds(Iterable<T> it) {
		List<String> ids = new ArrayList<>();
		for (EntityBase obj: it) {
			if (obj.getId()!=null) {
				ids.add(obj.getId());				
			}
		}
		return ids;
	}

	public static <T extends EntityBase> List<String> getUuids(Iterable<T> it) {
		List<String> ids = new ArrayList<>();
		for (EntityBase obj: it) {
			if (obj.getUuid()!=null) {
				ids.add(obj.getUuid());				
			}
		}
		return ids;
	}
}
