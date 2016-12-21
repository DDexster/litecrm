package com.litecrm.entities.employee;

import com.litecrm.entities.department.Department;
import com.litecrm.entities.person.Person;
import com.litecrm.entities.workgroup.Workgroup;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID", unique = true)
    private Person contact;

    private String position;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Department department;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Workgroup workgroup;

    private Date hireDate;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public Employee setId(long id) {
        this.id = id;
        return this;
    }

    public Person getContact() {
        return contact;
    }

    public Employee setContact(Person contact) {
        this.contact = contact;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Employee setHireDate(Date hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public Workgroup getWorkgroup() {
        return workgroup;
    }

    public Employee setWorkgroup(Workgroup workgroup) {
        this.workgroup = workgroup;
        return this;
    }
}
