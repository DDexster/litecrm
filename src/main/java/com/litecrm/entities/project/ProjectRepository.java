package com.litecrm.entities.project;

import com.litecrm.entities.department.Department;
import com.litecrm.entities.workgroup.Workgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Project p WHERE p.subject = :subject")
    boolean isExist(@Param("subject") String subject);

    @Query("select distinct p FROM Project p WHERE p.subject = :subject")
    Project getBySubject(@Param("subject") String subject);

    @Query("select distinct p FROM Project p WHERE p.assignment = :assignment")
    Project getByAssignment(@Param("assignment") String assignment);

    @Query("select distinct p FROM Project p WHERE p.workgroup = :workgroup")
    List<Project> findByWorkgroup(@Param("workgroup") Workgroup workgroup);

    @Query("select distinct p FROM Project p WHERE p.department = :department")
    List<Project> findByDepartment(@Param("department") Department department);

    @Query("select distinct p FROM Project p WHERE p.startDate = :date")
    List<Project> findByStartDate(@Param("date") Date date);

    @Query("select distinct p FROM Project p WHERE p.startDate >= :startDate and p.startDate <= :endDate")
    List<Project> findByStartDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select distinct p FROM Project p WHERE p.startDate >= :date")
    List<Project> findFromStartDate(@Param("date") Date date);

    @Query("select distinct p FROM Project p WHERE p.startDate <= :date")
    List<Project> findToStartDate(@Param("date") Date date);

    @Query("select distinct p FROM Project p WHERE p.endDate = :date")
    List<Project> findByEndDate(@Param("date") Date date);

    @Query("select distinct p FROM Project p WHERE p.endDate >= :startDate and p.endDate <= :endDate")
    List<Project> findByEndDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select distinct p FROM Project p WHERE p.endDate >= :date")
    List<Project> findFromEndDate(@Param("date") Date date);

    @Query("select distinct p FROM Project p WHERE p.endDate <= :date")
    List<Project> findToEndDate(@Param("date") Date date);
}
