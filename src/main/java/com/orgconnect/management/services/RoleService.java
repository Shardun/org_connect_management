package com.orgconnect.management.services;

import java.util.List;

import com.orgconnect.management.entities.Role;

public interface RoleService {
    // Get all roles
    List<Role> getAllRoles();

    // Get role by ID
    Role getRoleById(Long id);

    // Create a new role
    Role createRole(Role role);

    // Update an existing role
    Role updateRole(Long id, Role role);

    // Delete a role by ID
    boolean deleteRole(Long id);

}
