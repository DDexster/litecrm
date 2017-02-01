package com.litecrm.entities.employee;

import com.litecrm.entities.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 16.12.16.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT DISTINCT e from Employee e WHERE e.contact = :contact")
    Employee findByContact(@Param("contact") Person contact);

    @Query("SELECT e from Employee e WHERE e.position = :position")
    List<Employee> findByPosition(@Param("position") String position);

    @Query("SELECT e from Employee e WHERE e.department = :department")
    List<Employee> findByDepartment(@Param("department") String department);

    @Query("SELECT e from Employee e WHERE e.date = :date")
    List<Employee> findByHireDate(@Param("date") Date date);

    @Query("SELECT e from Employee e WHERE e.date >= :start and e.date <= :endDate")
    List<Employee> findByHireDate(@Param("start") Date start, @Param("endDate") Date endDate);

    @Query("SELECT e from Employee e WHERE e.date >= :date")
    List<Employee> findFromHireDate(Date date);

    @Query("SELECT e from Employee e WHERE e.date <= :date")
    List<Employee> findToHireDate(Date date);
}
