package com.litecrm.entities.division;

import com.litecrm.entities.department.Department;
import com.litecrm.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM Division d WHERE d.name = :name")
    boolean isExist(@Param("name") String name);

    @Query("select distinct d FROM Division d WHERE d.name = :name")
    Division getByName(@Param("name") String name);

    @Query("select distinct d FROM Division d WHERE d.head = :head")
    Division getByHead(@Param("head") Employee head);

    @Query("select d FROM Division d WHERE :department MEMBER OF d.departments")
    List<Division> findByDepartment(@Param("department") Department department);
}
