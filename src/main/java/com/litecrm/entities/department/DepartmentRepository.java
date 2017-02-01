package com.litecrm.entities.department;

import com.litecrm.entities.division.Division;
import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM Department d WHERE d.name = :name")
    boolean isExist(@Param("name") String name);

    @Query("select d FROM Department d WHERE d.name = :name")
    Department getByName(@Param("name") String name);

    @Query("select d FROM Department d WHERE d.head = :head")
    Department getByHead(@Param("head") Employee head);

    @Query("select d FROM Department d WHERE :worker MEMBER OF d.workers")
    List<Department> findByWorker(@Param("worker") Employee worker);

    @Query("select d FROM Department d WHERE d.division = :division")
    List<Department> findByDivision(@Param("division") Division division);

    @Query("select d FROM Department d WHERE :project MEMBER OF d.projects")
    List<Department> findByProject(@Param("project") Project project);
}
