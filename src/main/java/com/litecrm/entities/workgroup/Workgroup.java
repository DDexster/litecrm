package com.litecrm.entities.workgroup;

import com.litecrm.entities.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workgroups")
public class Workgroup {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "workgroup", cascade = CascadeType.ALL)
    @JoinColumn(name = "HEAD_ID")
    private Employee head;

    @OneToMany
    private List<Employee> group;

    private String project;

    public Workgroup() {
    }

    public long getId() {
        return id;
    }

    public Workgroup setId(long id) {
        this.id = id;
        return this;
    }

    public Employee getHead() {
        return head;
    }

    public Workgroup setHead(Employee head) {
        this.head = head;
        return this;
    }

    public List<Employee> getGroup() {
        return group;
    }

    public Workgroup setGroup(List<Employee> group) {
        for (Employee employee : group) {
            employee.setWorkgroup(this);
        }
        this.group = group;
        return this;
    }

    public Workgroup addEmployee(Employee employee) {
        employee.setWorkgroup(this);
        this.group.add(employee);
        return this;
    }

    public Workgroup removeEmployee(Employee employee) {
        employee.setDepartment(null);
        this.group.remove(employee);
        return this;
    }

    public String getProject() {
        return project;
    }

    public Workgroup setProject(String project) {
        this.project = project;
        return this;
    }
}
