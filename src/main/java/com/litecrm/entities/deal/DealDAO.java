package com.litecrm.entities.deal;

import com.litecrm.entities.client.Client;
import com.litecrm.entities.project.Project;

import java.util.Date;
import java.util.List;

public interface DealDAO {
    void addDeal(Deal deal);

    void removeDeal(Deal deal);

    void removeDeal(long id);

    boolean isExist(Project project);

    List<Deal> getAll();

    List<Deal> findByClient(Client client);

    Deal getByProject(Project project);

    List<Deal> findByPrice(double price);

    List<Deal> findByPrice(double startPrice, double endPrice);

    List<Deal> findFromPrice(double price);

    List<Deal> findToPrice(double price);

    List<Client> findByStartDate(Date date);

    List<Client> findByStartDate(Date start, Date end);

    List<Client> findFromStartDate(Date date);

    List<Client> findToStartDate(Date date);

    List<Client> findByEndDate(Date date);

    List<Client> findByEndDate(Date start, Date end);

    List<Client> findFromEndDate(Date date);

    List<Client> findToEndDate(Date date);
}
