package com.litecrm.entities.employee;

import com.litecrm.entities.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 16.12.16.
 */
@Service
@Transactional(readOnly = true)
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void removeEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    @Transactional
    public void removeEmployee(long id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByContact(Person contact) {
        return employeeRepository.findByContact(contact);
    }

    @Override
    public List<Employee> findByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public List<Employee> findByHireDate(Date date) {
        return employeeRepository.findByHireDate(date);
    }

    @Override
    public List<Employee> findByHireDate(Date start, Date end) {
        return employeeRepository.findByHireDate(start, end);
    }

    @Override
    public List<Employee> findFromHireDate(Date date) {
        return employeeRepository.findFromHireDate(date);
    }

    @Override
    public List<Employee> findToHireDate(Date date) {
        return employeeRepository.findToHireDate(date);
    }
}
