package com.litecrm.entities.project;

import com.litecrm.entities.department.Department;
import com.litecrm.entities.workgroup.Workgroup;

import java.util.Date;
import java.util.List;

public interface ProjectDAO {
    void addProject(Project project);

    void removeProject(Project project);

    void removeProject(long id);

    boolean isExist(String subject);

    List<Project> getAll();

    Project getBySubject(String subject);

    Project getByAssignment(String assignment);

    List<Project> findByWorkgroup(Workgroup workgroup);

    List<Project> findByDepartment(Department department);

    List<Project> findByStartDate(Date date);

    List<Project> findByStartDate(Date start, Date end);

    List<Project> findFromStartDate(Date date);

    List<Project> findToStartDate(Date date);

    List<Project> findByEndDate(Date date);

    List<Project> findByEndDate(Date start, Date end);

    List<Project> findFromEndDate(Date date);

    List<Project> findToEndDate(Date date);
}
