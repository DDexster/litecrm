package com.litecrm.entities.workgroup;

import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.project.Project;
import com.litecrm.security.userdb.CustomUser;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workgroups")
public class Workgroup {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "workgroup", cascade = CascadeType.ALL)
    @JoinColumn(name = "HEAD_ID", nullable = false, unique = true)
    private Employee head;

    @OneToMany
    private List<Employee> group;

    @OneToOne(mappedBy = "workgroup", cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    private CustomUser createdBy;


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

    public Project getProject() {
        return project;
    }

    public Workgroup setProject(Project project) {
        this.project = project;
        return this;
    }

    public CustomUser getCreatedBy() {
        return createdBy;
    }

    public Workgroup setCreatedBy(CustomUser createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
