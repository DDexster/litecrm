package com.litecrm.entities.department;

import com.litecrm.entities.division.Division;
import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ddexster on 23.12.16.
 */
@Service
@Transactional(readOnly = true)
public class DepatrmentDAOImpl implements DepartmentDAO {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void removeDepartment(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    @Transactional
    public void removeDepartment(long id) {
        departmentRepository.delete(id);
    }

    @Override
    public boolean isExist(String name) {
        return departmentRepository.isExist(name);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.getByName(name);
    }

    @Override
    public Department getByHead(Employee head) {
        return departmentRepository.getByHead(head);
    }

    @Override
    public List<Department> findByWorker(Employee worker) {
        return departmentRepository.findByWorker(worker);
    }

    @Override
    public List<Department> findByDivision(Division division) {
        return departmentRepository.findByDivision(division);
    }

    @Override
    public List<Department> findByProject(Project project) {
        return departmentRepository.findByProject(project);
    }
}
