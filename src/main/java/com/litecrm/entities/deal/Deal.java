package com.litecrm.entities.deal;

import com.litecrm.entities.client.Client;
import com.litecrm.entities.project.Project;
import com.litecrm.security.userdb.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "CLIENT_ID")
    private Client client;

    @OneToOne(mappedBy = "deal", cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID", unique = true)
    private Project project;

    @Column(nullable = false)
    private double price;

    @Temporal(TemporalType.DATE)
    private Date startDate = project.getStartDate();

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate = project.getEndDate();

    private CustomUser createdBy;

    public Deal() {
    }

    public CustomUser getCreatedBy() {
        return createdBy;
    }

    public Deal setCreatedBy(CustomUser createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public long getId() {
        return id;
    }

    public Deal setId(long id) {
        this.id = id;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Deal setClient(Client client) {
        client.addDeal(this);
        this.client = client;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public Deal setProject(Project project) {
        this.project = project;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Deal setPrice(double price) {
        this.price = price;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Deal setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Deal setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
