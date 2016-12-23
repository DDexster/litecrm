package com.litecrm.entities.workgroup;

import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.project.Project;

import java.util.List;

public interface WorkgroupDAO {

    void addWorkgroup(Workgroup workgroup);

    void removeWorkgroup(Workgroup workgroup);

    void removeWorkgroup(long id);

    boolean isExist(Employee head);

    List<Workgroup> getAll();

    Workgroup getWorkgroup(Employee head);

    List<Workgroup> findByMember(Employee member);

    List<Workgroup> findByProject(Project project);


}
