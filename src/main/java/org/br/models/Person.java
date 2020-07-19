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

import java.util.Objects;

@Entity
@Cacheable
@Table
public class Person extends PanacheEntityBase {

	@EmbeddedId
	public PersonId id;

    @NotNull(message = "Name is empty")
    @Column(length = 40)
    public String name;

    @NotNull(message = "Gender is empty")
    @Column(length = 1)
    @Convert(converter = PersonType.Mapper.class)
    public PersonType gender;

    @NotNull(message = "Phone is empty")
    @Column(length = 40)
    public String phone;

    @NotNull(message = "City is empty")
    @Column(length = 40)
    public String city;

    @NotNull(message = "District is empty")
    @Column(length = 40)
    public String district;

	@NotNull(message = "DistrictCode is empty")
	@Column(length = 40)
	public String districtCode;

	@NotNull(message = "CountryCode is empty")
	@Column(length = 40)
	public String countryCode;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(id, person.id) &&
				Objects.equals(name, person.name) &&
				gender == person.gender &&
				Objects.equals(phone, person.phone) &&
				Objects.equals(city, person.city) &&
				Objects.equals(district, person.district) &&
				Objects.equals(districtCode, person.districtCode) &&
				Objects.equals(countryCode, person.countryCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, gender, phone, city, district, districtCode, countryCode);
	}


}