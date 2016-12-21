package com.litecrm.entities.division;

import com.litecrm.entities.department.Department;
import com.litecrm.entities.employee.Employee;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ddexster on 16.12.16.
 */
@Entity
@Table(name = "divisions")
public class Division {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HEAD_ID")
    private Employee head;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private List<Department> departments;

    public Division() {
    }

    public long getId() {
        return id;
    }

    public Division setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Division setName(String name) {
        this.name = name;
        return this;
    }

    public Employee getHead() {
        return head;
    }

    public Division setHead(Employee head) {
        this.head = head;
        return this;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Division setDepartments(List<Department> departments) {
        for (Department department : departments) {
            department.setDivision(this);
        }
        this.departments = departments;
        return this;
    }

    public Division addDepartment(Department department) {
        department.setDivision(this);
        this.departments.add(department);
        return this;
    }

    public Division removeDepartment(Department department) {
        department.setDivision(null);
        this.departments.remove(department);
        return this;
    }
}
