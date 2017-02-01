package com.litecrm.entities.person;

import com.litecrm.entities.ContactType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 12.12.16.
 */
@Service
public class PersonDAOImpl implements PersonDAO {
    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public void addContact(Person person) {
        personRepository.save(person);
    }

    @Override
    @Transactional
    public void addContact(List<Person> persons) {
        personRepository.save(persons);
    }

    @Override
    @Transactional
    public void removeContact(Person person) {
        personRepository.delete(person);
    }

    @Override
    @Transactional
    public void removeContact(long id) {
        personRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(String email) {
        return personRepository.isExist(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> getPersonByType(ContactType type) {
        return personRepository.findByType(type);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findByPhone(String phone) {
        return personRepository.findByPhone(phone);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findByBirthDate(Date date) {
        return personRepository.findByBirthDate(date);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findByBirthDate(Date start, Date end) {
        return personRepository.findByBirthDate(start, end);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findFromBirthDate(Date date) {
        return personRepository.findFromBirthDate(date);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findToBirthDate(Date date) {
        return personRepository.findToBirthDate(date);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
