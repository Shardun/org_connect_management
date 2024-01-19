package com.orgconnect.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgconnect.management.Exceptions.ResourceNotFoundException;
import com.orgconnect.management.Exceptions.DeletionException;
import com.orgconnect.management.entities.Employee;
import com.orgconnect.management.entities.Role;
import com.orgconnect.management.repositories.EmployeeRepository;
import com.orgconnect.management.repositories.RoleRepository;
import com.orgconnect.management.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("Given role id is not found "+id));
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        if (roleRepository.existsById(id)) {
            role.setRoleId(id);
            return roleRepository.save(role);
        }
        else{
            throw new ResourceNotFoundException("Given role id is not found "+id);
        }
        
    }

    @Override
    public boolean deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Given role id is not found " + id));
        // Check if the role is associated with any employees
        List<Employee> employeesWithRole = employeeRepository.findByRole(role);

        if (employeesWithRole.isEmpty()) {
            // If there are no associated employees, proceed with deletion
            roleRepository.delete(role);
            return true;
        } else {
            // If there are associated employees, prevent deletion and throw an exception
            throw new DeletionException("Role cannot be deleted as it is associated with one or more employees.");
        }
    }
}
