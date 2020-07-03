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
    @Column(length = 40, unique = true)
    public String email;

    @NotNull(message = "Birthday is empty")
    @Column(length = 40, unique = true)
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

    

}