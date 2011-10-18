package org.springframework.samples.petclinic;

import java.util.Date;

/**
 * Simple JavaBean domain object representing a visit.
 * 
 * @author Ken Krebs
 */
public class Visit implements BaseEntity {

    private Date date;
    private String description;
    private Integer id;
    private Pet pet;

    /** Creates a new instance of Visit for the current date */
    public Visit() {
        this.date = new Date();
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Pet getPet() {
        return this.pet;
    }

    @Override
    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean getIsNew() {
        return isNew();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

}
