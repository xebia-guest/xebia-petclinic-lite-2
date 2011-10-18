package org.springframework.samples.petclinic;

/**
 * @author Juergen Hoeller
 */
public class PetType implements NamedEntity {
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean getIsNew() {
        return isNew();
    }

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
