package com.litecrm.entities.lead;

import com.litecrm.entities.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 16.12.16.
 */
@Service
public class LeadDAOImpl implements LeadDAO {

    @Autowired
    private LeadRepository leadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Lead> getAll() {
        return leadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Lead findByPerson(Person person) {
        return leadRepository.findByPerson(person);
    }

    @Override
    @Transactional
    public void addLead(Lead lead) {
        leadRepository.save(lead);
    }

    @Override
    @Transactional
    public void removeLead(Lead lead) {
        leadRepository.delete(lead);
    }

    @Override
    @Transactional
    public void removeLead(long id) {
        leadRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Person person) {
        return leadRepository.isExist(person);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> findByInitiationDate(Date date) {
        return leadRepository.findByInitiationDate(date);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> findByInitiationDate(Date start, Date end) {
        return leadRepository.findByInitiationDate(start, end);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> findFromInitiationDate(Date date) {
        return leadRepository.findFromInitiationDate(date);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> findToInitiationDate(Date date) {
        return leadRepository.findToInitiationDate(date);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> findByCompanyName(String company) {
        return leadRepository.findByCompanyName(company);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> findByInterest(String interest) {
        return leadRepository.findByInterest(interest);
    }
}
