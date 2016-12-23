package com.litecrm.entities.deal;

import com.litecrm.entities.client.Client;
import com.litecrm.entities.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 23.12.16.
 */
@Service
@Transactional(readOnly = true)
public class DealDAOImpl implements DealDAO {
    @Autowired
    private DealRepository dealRepository;

    @Override
    @Transactional
    public void addDeal(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    @Transactional
    public void removeDeal(Deal deal) {
        dealRepository.delete(deal);
    }

    @Override
    @Transactional
    public void removeDeal(long id) {
        dealRepository.delete(id);
    }

    @Override
    public boolean isExist(Project project) {
        return dealRepository.isExist(project);
    }

    @Override
    public List<Deal> getAll() {
        return dealRepository.findAll();
    }

    @Override
    public List<Deal> findByClient(Client client) {
        return dealRepository.findByClient(client);
    }

    @Override
    public Deal getByProject(Project project) {
        return dealRepository.getByProject(project);
    }

    @Override
    public List<Deal> findByPrice(double price) {
        return dealRepository.findByPrice(price);
    }

    @Override
    public List<Deal> findByPrice(double startPrice, double endPrice) {
        return dealRepository.findByPrice(startPrice, endPrice);
    }

    @Override
    public List<Deal> findFromPrice(double price) {
        return dealRepository.findFromPrice(price);
    }

    @Override
    public List<Deal> findToPrice(double price) {
        return dealRepository.findToPrice(price);
    }

    @Override
    public List<Client> findByStartDate(Date date) {
        return dealRepository.findByStartDate(date);
    }

    @Override
    public List<Client> findByStartDate(Date start, Date end) {
        return dealRepository.findByStartDate(start, end);
    }

    @Override
    public List<Client> findFromStartDate(Date date) {
        return dealRepository.findFromStartDate(date);
    }

    @Override
    public List<Client> findToStartDate(Date date) {
        return dealRepository.findToStartDate(date);
    }

    @Override
    public List<Client> findByEndDate(Date date) {
        return dealRepository.findByEndDate(date);
    }

    @Override
    public List<Client> findByEndDate(Date start, Date end) {
        return dealRepository.findByEndDate(start, end);
    }

    @Override
    public List<Client> findFromEndDate(Date date) {
        return dealRepository.findFromEndDate(date);
    }

    @Override
    public List<Client> findToEndDate(Date date) {
        return dealRepository.findToEndDate(date);
    }
}
