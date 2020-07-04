package org.br.models;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Cacheable
public class Health extends PanacheEntityBase {
    
    @Id
    @NotNull(message = "PersonId is empty")
    public PersonId id;

    @NotNull(message = "Weight is empty")
    @Column(length = 40, unique = true)
    public Long weight;

    @NotNull(message = "Height is empty")
    @Column(length = 40, unique = true)
    public Long height;

    @NotNull(message = "Congenital diseases is empty")
    @Column(length = 40, unique = true)
    public Boolean congenitaldiseases;

    @NotNull(message = "Childhood diseases is empty")
    @Column(length = 40, unique = true)
    public Boolean childhoodDiseases;

    @NotNull(message = "Heart diseases is empty")
    @Column(length = 40, unique = true)
    public Boolean heartDiseases;

    @NotNull(message = "Respiratory diseases is empty")
    @Column(length = 40, unique = true)
    public Boolean respiratoryDiseases;

    @NotNull(message = "Kidney diseases is empty")
    @Column(length = 40, unique = true)
    public Boolean kidneyDiseases;

    @NotNull(message = "Neurological diseases is empty")
    @Column(length = 40, unique = true)
    public Boolean neurologicalDiseases;

    @NotNull(message = "Other comorbidities is empty")
    @Column(length = 40, unique = true)
    public Boolean otherComorbidities;

    @NotNull(message = "Health treatment is empty")
    @Column(length = 40, unique = true)
    public Boolean healthTreatment;
}
