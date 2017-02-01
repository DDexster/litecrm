package com.litecrm.entities.division;

import com.litecrm.entities.department.Department;
import com.litecrm.entities.employee.Employee;

import java.util.List;

public interface DivisionDAO {

    void addDivision(Division division);

    void removeDivision(Division division);

    void removeDivision(long id);

    boolean isExist(String name);

    List<Division> getAll();

    Division getByName(String name);

    Division getByHead(Employee head);

    List<Division> findByDepartment(Department department);

}
