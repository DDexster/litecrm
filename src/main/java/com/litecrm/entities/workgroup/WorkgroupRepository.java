package com.litecrm.entities.workgroup;

import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkgroupRepository extends JpaRepository<Workgroup, Long> {

    @Query("SELECT CASE WHEN COUNT(w) > 0 THEN true ELSE false END FROM Workgroup w WHERE w.head = :head")
    boolean isExist(@Param("head") Employee head);

    @Query("select distinct w FROM Workgroup w WHERE w.head = :head")
    Workgroup getWorkgroup(@Param("head") Employee head);

    @Query("select w FROM Workgroup w WHERE :memberG MEMBER OF w.group")
    List<Workgroup> findByMember(@Param("memberG") Employee member);

    @Query("select w FROM Workgroup w WHERE w.project = :project")
    List<Workgroup> findByProject(@Param("project") Project project);
}
