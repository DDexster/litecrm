package com.litecrm.entities.department;

import com.litecrm.entities.division.Division;
import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.project.Project;
import com.litecrm.security.userdb.CustomUser;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    @JoinColumn(name = "HEAD_ID")
    private Employee head;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> workers;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Division division;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Project> projects;

    private CustomUser createdBy;

    public Department() {
    }

    public CustomUser getCreatedBy() {
        return createdBy;
    }

    public Department setCreatedBy(CustomUser createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public long getId() {
        return id;
    }

    public Department setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public Employee getHead() {
        return head;
    }

    public Department setHead(Employee head) {
        head.setDepartment(this);
        head.setDivision(this.division);
        this.head = head;
        return this;
    }

    public List<Employee> getWorkers() {
        return workers;
    }

    public Department setWorkers(List<Employee> workers) {
        for (Employee worker : workers) {
            worker.setDepartment(this);
            worker.setDivision(this.division);
        }
        this.workers = workers;
        return this;
    }

    public Department addWorker(Employee employee) {
        employee.setDepartment(this);
        employee.setDivision(this.division);
        this.workers.add(employee);
        return this;
    }

    public Department removeWorker(Employee employee) {
        employee.setDepartment(null);
        employee.setDivision(null);
        this.workers.remove(employee);
        return this;
    }

    public Division getDivision() {
        return division;
    }

    public Department setDivision(Division division) {
        this.division = division;
        return this;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Department setProjects(List<Project> projects) {
        for (Project project : projects) {
            project.setDepartment(this);
        }
        this.projects = projects;
        return this;
    }

    public Department addProject(Project project) {
        project.setDepartment(this);
        this.projects.add(project);
        return this;
    }

    public Department removeProject(Project project) {
        project.setDepartment(null);
        this.projects.remove(project);
        return this;
    }

}
