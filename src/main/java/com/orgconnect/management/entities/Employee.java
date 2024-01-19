package com.orgconnect.management.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    
    @NotBlank(message = "Employee Name must not be blank")
    private String employeeName;
    
    @NotBlank(message = "Email must not be blank")
    @Email(message ="Invalid email format")
    private String email;
    
    @NotBlank(message = "Mobile Number must not be blank")
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10,14}$", message = "Invalid mobile number format")
    private String mobileNumber;

    @NotNull(message = "Age must not be blank")
    @Min(value= 18, message = "Age must be at least 18 years")
    Integer age;

    @ManyToOne
    @JoinColumn(name = "role_id") // Many-to-One relationship with Role
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id") // Many-to-One relationship with Department
    private Department department;

    @ManyToOne
    @JoinColumn(name = "sub_organization_id") // Many-to-One relationship with Suborganization
    private SubOrganization subOrganization;
}
