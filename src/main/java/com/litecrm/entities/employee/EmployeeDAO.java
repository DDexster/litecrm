package com.litecrm.entities.employee;

import com.litecrm.entities.person.Person;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 16.12.16.
 */
public interface EmployeeDAO {
    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    void removeEmployee(long id);

    List<Employee> getAll();

    Employee findByContact(Person contact);

    List<Employee> findByPosition(String position);

    List<Employee> findByDepartment(String department);

    List<Employee> findByHireDate(Date date);

    List<Employee> findByHireDate(Date start, Date end);

    List<Employee> findFromHireDate(Date date);

    List<Employee> findToHireDate(Date date);
}
