package com.litecrm.entities.person;

import com.litecrm.entities.client.Client;
import com.litecrm.entities.employee.Employee;
import com.litecrm.entities.lead.Lead;
import com.litecrm.security.userdb.CustomUser;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Person {

    @Column(nullable = false, unique = true)
    String email;
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String fatherName;
    @Column(nullable = false)
    private List<String> phones = new LinkedList<>();
    private List<String> addresses = new LinkedList<>();

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String skype;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "LEAD_ID")
    private Lead lead;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    private CustomUser createdBy;

    public Person() {
    }

    public long getId() {
        return id;
    }

    public Lead getLead() {
        return lead;
    }

    public Person setLead(Lead lead) {
        this.lead = lead;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Person setClient(Client client) {
        this.client = client;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Person setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<String> getPhones() {
        return phones;
    }

    public Person setPhones(List<String> phones) {
        this.phones = phones;
        return this;
    }

    public Person addPhone(String phone) {
        if (!this.phones.contains(phone)) {
            this.phones.add(phone);
            return this;
        }
        return this;
    }

    public Person removePhone(String phone) {
        if (this.phones.contains(phone)) {
            this.phones.remove(phone);
            return this;
        }
        return this;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public Person setAddresses(List<String> addresses) {
        this.addresses = addresses;
        return this;
    }

    public Person addAddress(String address) {
        if (!this.addresses.contains(address)) {
            this.addresses.add(address);
            return this;
        }
        return this;
    }

    public Person removeAddress(String address) {
        if (this.addresses.contains(address)) {
            this.addresses.remove(address);
            return this;
        }
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Person setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getSkype() {
        return skype;
    }

    public Person setSkype(String skype) {
        this.skype = skype;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Person setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public CustomUser getCreatedBy() {
        return createdBy;
    }

    public Person setCreatedBy(CustomUser createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
