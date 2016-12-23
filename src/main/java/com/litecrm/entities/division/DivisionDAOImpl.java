package com.litecrm.entities.division;

import com.litecrm.entities.department.Department;
import com.litecrm.entities.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DivisionDAOImpl implements DivisionDAO {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    @Transactional
    public void addDivision(Division division) {
        divisionRepository.save(division);
    }

    @Override
    @Transactional
    public void removeDivision(Division division) {
        divisionRepository.delete(division);
    }

    @Override
    @Transactional
    public void removeDivision(long id) {
        divisionRepository.delete(id);
    }

    @Override
    public boolean isExist(String name) {
        return divisionRepository.isExist(name);
    }

    @Override
    public List<Division> getAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division getByName(String name) {
        return divisionRepository.getByName(name);
    }

    @Override
    public Division getByHead(Employee head) {
        return divisionRepository.getByHead(head);
    }

    @Override
    public List<Division> findByDepartment(Department department) {
        return divisionRepository.findByDepartment(department);
    }
}
