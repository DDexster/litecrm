package com.litecrm.entities.department;

import com.litecrm.entities.division.Division;
import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.project.Project;

import java.util.List;

public interface DepartmentDAO {

    void addDepartment(Department department);

    void removeDepartment(Department department);

    void removeDepartment(long id);

    boolean isExist(String name);

    List<Department> getAll();

    Department getByName(String name);

    Department getByHead(Employee head);

    List<Department> findByWorker(Employee worker);

    List<Department> findByDivision(Division division);

    List<Department> findByProject(Project project);
}
