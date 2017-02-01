package com.litecrm.entities.client;

import com.litecrm.entities.lead.Lead;
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
@Transactional(readOnly = true)
public class ClientDAOImpl implements ClientDAO {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void removeClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    @Transactional
    public void removeClient(long id) {
        clientRepository.delete(id);
    }

    @Override
    public boolean isExist(Lead head) {
        return clientRepository.isExist(head);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findByContact(Person person) {
        return clientRepository.findByContact(person);
    }

    @Override
    public Client findByContact(Lead head) {
        return clientRepository.findByContact(head);
    }

    @Override
    public List<Client> findByCompanyName(String company) {
        return clientRepository.findByCompanyName(company);
    }

    @Override
    public List<Client> findByCountry(String country) {
        return clientRepository.findByCountry(country);
    }

    @Override
    public List<Client> findByTaxNumber(int taxNumber) {
        return clientRepository.findByTaxNumber(taxNumber);
    }

    @Override
    public List<Client> findByLicenseNumber(int licenseNumber) {
        return clientRepository.findByLicenseNumber(licenseNumber);
    }

    @Override
    public List<Client> findByBankAcconut(long account) {
        return clientRepository.findByBankAcconut(account);
    }

    @Override
    public List<Client> findByBankCode(int bankCode) {
        return clientRepository.findByBankCode(bankCode);
    }

    @Override
    public List<Client> findByInitDate(Date date) {
        return clientRepository.findByInitDate(date);
    }

    @Override
    public List<Client> findByInitDate(Date start, Date end) {
        return clientRepository.findByInitDate(start, end);
    }

    @Override
    public List<Client> findFromInitDate(Date date) {
        return clientRepository.findFromInitDate(date);
    }

    @Override
    public List<Client> findToInitDate(Date date) {
        return clientRepository.findToInitDate(date);
    }
}
