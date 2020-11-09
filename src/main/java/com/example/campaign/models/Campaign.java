package com.example.campaign.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This is the Campaign entity model, representing the Campaign
 *
 * Validation are represented by validation constrains
 */
@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "'name' cannot be empty.")
    @Size(min = 3, message = "'name' should have at least 3 characters")
    private String name;

    @NotNull(message = "'description' cannot be empty.")
    private String description;

    @NotNull(message = "'isActive' must be 'true' or 'false' value.")
    private Boolean isActive;

    public Campaign() {}

    public Campaign(String name, String description, Boolean isActive) {

        this.name = name;
        this.description = description;
        this.isActive = isActive;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        this.isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campaign)) return false;

        Campaign campaign = (Campaign) o;

        if (id != null ? !id.equals(campaign.id) : campaign.id != null) return false;
        if (name != null ? !name.equals(campaign.name) : campaign.name != null) return false;
        if (description != null ? !description.equals(campaign.description) : campaign.description != null) return false;
        return isActive != null ? isActive.equals(campaign.isActive) : campaign.isActive == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }
}
