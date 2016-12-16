package com.litecrm.entities.lead;

import com.litecrm.entities.person.Person;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 13.12.16.
 */
public interface LeadDAO {

    void addLead(Lead lead);

    void removeLead(Lead lead);

    void removeLead(long id);

    boolean isExist(Person person);

    List<Lead> getAll();

    Lead findByPerson(Person person);

    List<Lead> findByInitiationDate(Date date);

    List<Lead> findByInitiationDate(Date start, Date end);

    List<Lead> findFromInitiationDate(Date date);

    List<Lead> findToInitiationDate(Date date);

    List<Lead> findByCompanyName(String company);

    List<Lead> findByInterest(String interest);
//    List<Lead> findByInterests (Collection<String> interests);

}

