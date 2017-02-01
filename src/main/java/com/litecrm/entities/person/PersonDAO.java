package com.litecrm.entities.person;

import com.litecrm.entities.ContactType;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 12.12.16.
 */
public interface PersonDAO {
    void addContact(Person person);

    void addContact(List<Person> persons);

    void removeContact(Person person);

    void removeContact(long id);

    boolean isExist(String email);

    List<Person> getAll();

    List<Person> getPersonByType(ContactType type);

    List<Person> findByName(String name);

    List<Person> findByLastName(String lastName);

    List<Person> findByPhone(String phone);

    Person findByEmail(String email);

    List<Person> findByBirthDate(Date date);

    List<Person> findByBirthDate(Date start, Date end);

    List<Person> findFromBirthDate(Date date);

    List<Person> findToBirthDate(Date date);

}
