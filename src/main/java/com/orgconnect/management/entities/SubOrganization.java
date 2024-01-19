package com.orgconnect.management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class SubOrganization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subOrganizationId;
    @NotBlank(message = "Sub Organization Name must not be blank")
    private String subOrganizationName;
    @NotBlank(message = "Founding Date must not be blank")
    private String foundingDate;
    @NotBlank(message = "Location must not be blank")
    private String location;
    private String description;

    @ManyToOne
    @JoinColumn(name = "organization_Id")
    private Organization organization;

}
