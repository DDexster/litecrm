package com.litecrm.entities.client;

import com.litecrm.entities.lead.Lead;
import com.litecrm.entities.person.Person;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 16.12.16.
 */
public interface ClientDAO {

    void addClient(Client client);

    void removeClient(Client client);

    void removeClient(long id);

    boolean isExist(Lead head);

    List<Client> getAll();

    List<Client> findByContact(Person person);

    Client findByContact(Lead head);

    List<Client> findByCompanyName(String company);

    List<Client> findByCountry(String country);

    List<Client> findByTaxNumber(int taxNumber);

    List<Client> findByLicenseNumber(int licenseNumber);

    List<Client> findByBankAcconut(long account);

    List<Client> findByBankCode(int bankCode);

    List<Client> findByInitDate(Date date);

    List<Client> findByInitDate(Date start, Date end);

    List<Client> findFromInitDate(Date date);

    List<Client> findToInitDate(Date date);

}
