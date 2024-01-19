package com.orgconnect.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgconnect.management.Exceptions.ResourceNotFoundException;
import com.orgconnect.management.entities.Department;
import com.orgconnect.management.entities.Employee;
import com.orgconnect.management.entities.Role;
import com.orgconnect.management.entities.SubOrganization;
import com.orgconnect.management.repositories.DepartmentRepository;
import com.orgconnect.management.repositories.EmployeeRepository;
import com.orgconnect.management.repositories.RoleRepository;
import com.orgconnect.management.repositories.SubOrganizationRepository;
import com.orgconnect.management.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired 
    private SubOrganizationRepository subOrganizationRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        if(employeeRepository.existsById(id)){
            return employeeRepository.findById(id).orElse(null);
        }
        else{
                throw new ResourceNotFoundException("Given employee id is not found "+id);
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if(employee.getRole() != null && employee.getRole().getRoleId() != null){
            Role role = roleRepository.findById(employee.getRole().getRoleId()).orElse(null);
            if(role!=null){
                employee.setRole(role);
            }
            else{
                    //if role not found
                    throw new ResourceNotFoundException("Given role id is not found "+employee.getRole().getRoleId());
            }
        }
        else{
                //if role id is missing from payload
                throw new ResourceNotFoundException("Role or Role id is missing.");
        }
        if(employee.getDepartment() != null && employee.getDepartment().getDepartmentId() != null){
            Department department = departmentRepository.findById(employee.getDepartment().getDepartmentId()).orElse(null);
            if(department!=null){
                employee.setDepartment(department);
            }
            else{
                    //if dept not found
                    throw new ResourceNotFoundException("Given department id is not found "+employee.getDepartment().getDepartmentId());
            }
        }
        else{
                //if role id is missing from payload
                throw new ResourceNotFoundException("Department or Department id is missing.");
            
        }
        if(employee.getSubOrganization() != null && employee.getSubOrganization().getSubOrganizationId() != null){
            SubOrganization suborganization = subOrganizationRepository.findById(employee.getSubOrganization().getSubOrganizationId()).orElse(null);
            if(suborganization!=null){
                employee.setSubOrganization(suborganization);
            }
            else{
                    //if dept not found
                    throw new ResourceNotFoundException("Given sub organization id is not found "+employee.getSubOrganization().getSubOrganizationId());
            }
        }
        else{
                //if role id is missing from payload
                throw new ResourceNotFoundException("Sub Organization or Sub organization id is missing.");
        }
        
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setEmployeeId(id);

                    if(employee.getRole() != null && employee.getRole().getRoleId() != null){
            Role role = roleRepository.findById(employee.getRole().getRoleId()).orElse(null);
            if(role!=null){
                employee.setRole(role);
            }
            else{
                    //if role not found
                    throw new ResourceNotFoundException("Given role id is not found "+employee.getRole().getRoleId());
            }
        }
        else{
                //if role id is missing from payload
                throw new ResourceNotFoundException("Role or Role id is missing.");
        }
        if(employee.getDepartment() != null && employee.getDepartment().getDepartmentId() != null){
            Department department = departmentRepository.findById(employee.getDepartment().getDepartmentId()).orElse(null);
            if(department!=null){
                employee.setDepartment(department);
            }
            else{
                    //if dept not found
                    throw new ResourceNotFoundException("Given department id is not found "+employee.getDepartment().getDepartmentId());
            }
        }
        else{
                //if role id is missing from payload
                throw new ResourceNotFoundException("Department or Department id is missing.");
            
        }
        if(employee.getSubOrganization() != null && employee.getSubOrganization().getSubOrganizationId() != null){
            SubOrganization suborganization = subOrganizationRepository.findById(employee.getSubOrganization().getSubOrganizationId()).orElse(null);
            if(suborganization!=null){
                employee.setSubOrganization(suborganization);
            }
            else{
                    //if dept not found
                    throw new ResourceNotFoundException("Given sub organization id is not found "+employee.getSubOrganization().getSubOrganizationId());
            }
        }
        else{
                //if role id is missing from payload
                throw new ResourceNotFoundException("Sub organization or Sub organization id is missing.");
        }
            return employeeRepository.save(employee);
        }
        else{
                throw new ResourceNotFoundException("Given employee id is not found "+id);
        }
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        else{
                throw new ResourceNotFoundException("Given employee id is not found "+id);
        }
    }
}
