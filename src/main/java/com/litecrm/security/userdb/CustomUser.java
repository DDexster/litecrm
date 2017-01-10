package com.litecrm.security.userdb;

import javax.persistence.*;

@Entity
public class CustomUser {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String country;

    private String firstName;
    private String lastName;
    private String company;

    public CustomUser() {
    }

    public long getId() {
        return id;
    }

    public CustomUser setId(long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public CustomUser setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CustomUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public CustomUser setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CustomUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CustomUser setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public CustomUser setCompany(String company) {
        this.company = company;
        return this;
    }
}
