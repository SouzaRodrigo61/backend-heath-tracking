package org.br.models;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumns;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class HealthId implements Serializable {
    

    private static final long serialVersionUID = -8739724869885037482L;

    @ManyToOne(optional = true)
    @JoinColumns({
        @JoinColumn(name = "person_email", referencedColumnName = "email"),
        @JoinColumn(name = "person_birthday", referencedColumnName = "birthday"),
    })
    public Person personId;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof HealthId)) {
			return false;
		}
		HealthId other = (HealthId) obj;
		if (personId == null) {
			if (other.personId != null) {
				return false;
			}
		} else if (!personId.equals(other.personId)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the personId
	 */
	public Person getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Person personId) {
		this.personId = personId;
	}

    
}