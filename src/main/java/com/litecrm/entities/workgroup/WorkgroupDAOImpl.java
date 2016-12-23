package com.litecrm.entities.workgroup;

import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WorkgroupDAOImpl implements WorkgroupDAO {
    @Autowired
    private WorkgroupRepository workgroupRepository;

    @Override
    @Transactional
    public void addWorkgroup(Workgroup workgroup) {
        workgroupRepository.save(workgroup);
    }

    @Override
    @Transactional
    public void removeWorkgroup(Workgroup workgroup) {
        workgroupRepository.delete(workgroup);
    }

    @Override
    @Transactional
    public void removeWorkgroup(long id) {
        workgroupRepository.delete(id);
    }

    @Override
    public boolean isExist(Employee head) {
        return workgroupRepository.isExist(head);
    }

    @Override
    public List<Workgroup> getAll() {
        return workgroupRepository.findAll();
    }

    @Override
    public Workgroup getWorkgroup(Employee head) {
        return workgroupRepository.getWorkgroup(head);
    }

    @Override
    public List<Workgroup> findByMember(Employee member) {
        return workgroupRepository.findByMember(member);
    }

    @Override
    public List<Workgroup> findByProject(Project project) {
        return workgroupRepository.findByProject(project);
    }
}
