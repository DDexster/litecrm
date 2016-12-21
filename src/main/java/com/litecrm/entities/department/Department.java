package com.litecrm.entities.department;

import com.litecrm.entities.division.Division;
import com.litecrm.entities.employee.Employee;

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

    public Department() {
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
        this.head = head;
        return this;
    }

    public List<Employee> getWorkers() {
        return workers;
    }

    public Department setWorkers(List<Employee> workers) {
        for (Employee worker : workers) {
            worker.setDepartment(this);
        }
        this.workers = workers;
        return this;
    }

    public Department addWorker(Employee employee) {
        employee.setDepartment(this);
        this.workers.add(employee);
        return this;
    }

    public Department removeWorker(Employee employee) {
        employee.setDepartment(null);
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
}
