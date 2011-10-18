package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple JavaBean domain object representing an owner.
 * 
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 */
public class Owner implements Person {

    private String address;
    private String city;
    private String firstName;
    private Integer id;
    private String lastName;
    private Set<Pet> pets;
    private String telephone;

    public void addPet(Pet pet) {
        getPetsInternal().add(pet);
        pet.setOwner(this);
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     * 
     * @param name
     *            to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     * 
     * @param name
     *            to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : getPetsInternal()) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }

    public List<Pet> getPets() {
        List<Pet> sortedPets = new ArrayList<Pet>(getPetsInternal());
        // sort removed
        return Collections.unmodifiableList(sortedPets);
    }

    protected Set<Pet> getPetsInternal() {
        if (this.pets == null) {
            this.pets = new HashSet<Pet>();
        }
        return this.pets;
    }

    public String getTelephone() {
        return this.telephone;
    }

    @Override
    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean getIsNew() {
        return isNew();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected void setPetsInternal(Set<Pet> pets) {
        this.pets = pets;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return String.format("Owner[%s]", id);
    }
}
