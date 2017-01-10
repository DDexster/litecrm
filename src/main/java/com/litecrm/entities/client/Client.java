package com.litecrm.entities.client;

import com.litecrm.entities.OrganisationForm;
import com.litecrm.entities.deal.Deal;
import com.litecrm.entities.lead.Lead;
import com.litecrm.entities.person.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 16.12.16.
 */
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    @JoinColumn(name = "HEAD_ID", nullable = false, unique = true)
    private Lead head;

    @Column(nullable = false)
    private String companyName = (head.getCompanyName() == null) ? (new String()) : (head.getCompanyName());

    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> contacts;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrganisationForm form;

    private String registrationCode;
    private String country;

    @Column(nullable = false)
    private int indTaxNum;
    private int taxLicenseNum;

    @Column(nullable = false)
    private long bankAccount;

    @Column(nullable = false)
    private int bankCode;

    private String notes;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date initDate;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Deal> deals;

    public Client() {
    }


    public long getId() {
        return id;
    }

    public Client setId(long id) {
        this.id = id;
        return this;
    }

    public Lead getHead() {
        return head;
    }

    public Client setHead(Lead head) {
        head.setClient(this);
        this.head = head;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Client setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public List<Person> getContacts() {
        return contacts;
    }

    public Client setContacts(List<Person> contacts) {
        this.contacts = contacts;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Client setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Date getInitDate() {
        return initDate;
    }

    public Client setInitDate(Date initDate) {
        this.initDate = initDate;
        return this;
    }

    public Client addContact(Person person) {
        person.setClient(this);
        this.contacts.add(person);
        return this;
    }

    public Client removeContact(Person person) {
        this.contacts.remove(person);
        return this;
    }

    public OrganisationForm getForm() {
        return form;
    }

    public Client setForm(OrganisationForm form) {
        this.form = form;
        return this;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public Client setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Client setCountry(String country) {
        this.country = country;
        return this;
    }

    public int getIndTaxNum() {
        return indTaxNum;
    }

    public Client setIndTaxNum(int indTaxNum) {
        this.indTaxNum = indTaxNum;
        return this;
    }

    public int getTaxLicenseNum() {
        return taxLicenseNum;
    }

    public Client setTaxLicenseNum(int taxLicenseNum) {
        this.taxLicenseNum = taxLicenseNum;
        return this;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public Client setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public int getBankCode() {
        return bankCode;
    }

    public Client setBankCode(int bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public Client setDeals(List<Deal> deals) {
        for (Deal deal : deals) {
            deal.setClient(this);
        }
        this.deals = deals;
        return this;
    }

    public Client addDeal(Deal deal) {
        deal.setClient(this);
        this.deals.add(deal);
        return this;
    }

    public Client removeDeal(Deal deal) {
        deal.setClient(null);
        this.deals.remove(deal);
        return this;
    }


}
