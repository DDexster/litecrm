package com.litecrm.entities.project;

import com.litecrm.entities.deal.Deal;
import com.litecrm.entities.department.Department;
import com.litecrm.entities.workgroup.Workgroup;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ddexster on 22.12.16.
 */
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String subject;

    @Column(nullable = false)
    private String assignment;

    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL)
    @JoinColumn(name = "WORKGROUP_ID")
    private Workgroup workgroup;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToOne(mappedBy = "project", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEAL_ID")
    private Deal deal;

    public Project() {
    }

    public long getId() {
        return id;
    }

    public Project setId(long id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Project setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getAssignment() {
        return assignment;
    }

    public Project setAssignment(String assignment) {
        this.assignment = assignment;
        return this;
    }

    public Workgroup getWorkgroup() {
        return workgroup;
    }

    public Project setWorkgroup(Workgroup workgroup) {
        workgroup.setProject(this);
        this.workgroup = workgroup;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Project setDepartment(Department department) {
        department.addProject(this);
        this.department = department;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Project setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Project setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
