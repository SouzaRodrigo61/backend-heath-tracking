package org.br.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PersonId implements Serializable {
    
    public static final long serialVersionUID = 3848505909300789567L;
    
    @NotNull(message = "Email is empty")
    @Column(length = 40)
    public String email;

    @NotNull(message = "Birthday is empty")
    @Column()
    public LocalDate birthday;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		return Objects.hash(birthday, email);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PersonId))
			return false;
		PersonId other = (PersonId) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(email, other.email);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonId [");
		if (birthday != null) {
			builder.append("birthday=").append(birthday).append(", ");
		}
		if (email != null) {
			builder.append("email=").append(email);
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * 
	 */
	public PersonId() {
	}


    

}