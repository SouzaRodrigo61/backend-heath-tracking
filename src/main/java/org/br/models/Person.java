package org.br.models;

import javax.validation.constraints.NotNull;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Convert;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import org.br.models.enums.PersonType;

@Entity
@Cacheable
public class Person extends PanacheEntity {


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

}