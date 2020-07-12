package org.br.models;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.br.models.enums.PersonType;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Cacheable
@Table
public class Person extends PanacheEntityBase {

	@EmbeddedId
	public PersonId id;

    @NotNull(message = "Name is empty")
    @Column(length = 40, unique = true)
    public String name;

    @NotNull(message = "Gender is empty")
    @Column(length = 1, nullable = false)
    @Convert(converter = PersonType.Mapper.class)
    public PersonType gender;

    @NotNull(message = "Phone is empty")
    @Column(length = 40, unique = true)
    public String phone;

    @NotNull(message = "City is empty")
    @Column(length = 40, unique = true)
    public String city;

    @NotNull(message = "District is empty")
    @Column(length = 40, unique = true)
    public String district;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [");
		if (city != null) {
			builder.append("city=").append(city).append(", ");
		}
		if (district != null) {
			builder.append("district=").append(district).append(", ");
		}
		if (gender != null) {
			builder.append("gender=").append(gender).append(", ");
		}
		if (id != null) {
			builder.append("id=").append(id).append(", ");
		}
		if (name != null) {
			builder.append("name=").append(name).append(", ");
		}
		if (phone != null) {
			builder.append("phone=").append(phone);
		}
		builder.append("]");
		return builder.toString();
	}


    
}