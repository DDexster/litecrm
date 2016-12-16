package com.litecrm.entities.lead;

import com.litecrm.entities.client.Client;
import com.litecrm.entities.person.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 12.12.16.
 */
@Entity
@Table(name = "lead")
public class Lead {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "CONTACT_ID", unique = true)
    private Person contact;

    private String companyName;
    private List<String> interests = new ArrayList<>();

    @Column(nullable = false)
    private Date initiationDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Client client;

    public Lead() {
    }

    public long getId() {
        return id;
    }

    public Person getContact() {
        return contact;
    }

    public Lead setContact(Person contact) {
        contact.setLead(this);
        this.contact = contact;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Lead setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public List<String> getInterests() {
        return interests;
    }

    public Lead setInterests(List<String> interests) {
        this.interests = interests;
        return this;
    }

    public void addInterest(String interest) {
        if (!this.interests.contains(interest)) {
            this.interests.add(interest);
        }
    }

    public void removeInterest(String interest) {
        if (this.interests.contains(interest)) {
            this.interests.remove(interest);
        }
    }

    public Date getInitiationDate() {
        return initiationDate;
    }

    public Lead setInitiationDate(Date initiationDate) {
        this.initiationDate = initiationDate;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Lead setClient(Client client) {
        this.client = client;
        return this;
    }
}
