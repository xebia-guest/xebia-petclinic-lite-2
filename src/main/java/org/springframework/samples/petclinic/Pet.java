package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple JavaBean business object representing a pet.
 * 
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 */
public class Pet implements NamedEntity {

    private Date birthDate;
    private Integer id;
    private String name;
    private Owner owner;
    private PetType type;
    private Set<Visit> visits;

    public void addVisit(Visit visit) {
        getVisitsInternal().add(visit);
        visit.setPet(this);
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public PetType getType() {
        return this.type;
    }

    public List<Visit> getVisits() {
        List<Visit> sortedVisits = new ArrayList<Visit>(getVisitsInternal());
        // sort removed
        return Collections.unmodifiableList(sortedVisits);
    }

    protected Set<Visit> getVisitsInternal() {
        if (this.visits == null) {
            this.visits = new HashSet<Visit>();
        }
        return this.visits;
    }

    @Override
    public boolean isNew() {
        return (this.id == null);
    }
    
    @Override
    public boolean getIsNew() {
        return isNew();
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    protected void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    protected void setVisitsInternal(Set<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
