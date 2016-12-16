package com.litecrm.entities.employee;

import com.litecrm.entities.person.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ddexster on 16.12.16.
 */
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
    private String department;
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

    public String getDepartment() {
        return department;
    }

    public Employee setDepartment(String department) {
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
}
