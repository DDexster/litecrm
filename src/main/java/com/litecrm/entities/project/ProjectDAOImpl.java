package com.litecrm.entities.project;

import com.litecrm.entities.department.Department;
import com.litecrm.entities.workgroup.Workgroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 23.12.16.
 */
@Service
@Transactional(readOnly = true)
public class ProjectDAOImpl implements ProjectDAO {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    @Transactional
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public void removeProject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    @Transactional
    public void removeProject(long id) {
        projectRepository.delete(id);
    }

    @Override
    public boolean isExist(String subject) {
        return projectRepository.isExist(subject);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getBySubject(String subject) {
        return projectRepository.getBySubject(subject);
    }

    @Override
    public Project getByAssignment(String assignment) {
        return projectRepository.getByAssignment(assignment);
    }

    @Override
    public List<Project> findByWorkgroup(Workgroup workgroup) {
        return projectRepository.findByWorkgroup(workgroup);
    }

    @Override
    public List<Project> findByDepartment(Department department) {
        return projectRepository.findByDepartment(department);
    }

    @Override
    public List<Project> findByStartDate(Date date) {
        return projectRepository.findByStartDate(date);
    }

    @Override
    public List<Project> findByStartDate(Date start, Date end) {
        return projectRepository.findByStartDate(start, end);
    }

    @Override
    public List<Project> findFromStartDate(Date date) {
        return projectRepository.findFromStartDate(date);
    }

    @Override
    public List<Project> findToStartDate(Date date) {
        return projectRepository.findToStartDate(date);
    }

    @Override
    public List<Project> findByEndDate(Date date) {
        return projectRepository.findByEndDate(date);
    }

    @Override
    public List<Project> findByEndDate(Date start, Date end) {
        return projectRepository.findByEndDate(start, end);
    }

    @Override
    public List<Project> findFromEndDate(Date date) {
        return projectRepository.findFromEndDate(date);
    }

    @Override
    public List<Project> findToEndDate(Date date) {
        return projectRepository.findToEndDate(date);
    }
}
