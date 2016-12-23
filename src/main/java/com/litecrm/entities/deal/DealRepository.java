package com.litecrm.entities.deal;

import com.litecrm.entities.client.Client;
import com.litecrm.entities.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DealRepository extends JpaRepository<Deal, Long> {

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM Deal d WHERE d.project = :project")
    boolean isExist(@Param("project") Project project);

    @Query("select d FROM Deal d WHERE d.client = :client")
    List<Deal> findByClient(@Param("client") Client client);

    @Query("select distinct d FROM Deal d WHERE d.project = :project")
    Deal getByProject(@Param("project") Project project);

    @Query("select d FROM Deal d WHERE d.price = :price")
    List<Deal> findByPrice(@Param("price") double price);

    @Query("select d FROM Deal d WHERE d.price >= :startPrice and d.price <= :endPrice")
    List<Deal> findByPrice(@Param("startPrice") double startPrice, @Param("endPrice") double endPrice);

    @Query("select d FROM Deal d WHERE d.price >= :price")
    List<Deal> findFromPrice(@Param("price") double price);

    @Query("select d FROM Deal d WHERE d.price <= :price")
    List<Deal> findToPrice(@Param("price") double price);

    @Query("select d FROM Deal d WHERE d.startDate = :date")
    List<Client> findByStartDate(@Param("date") Date date);

    @Query("select d FROM Deal d WHERE d.startDate >= :startDate and d.startDate <= :endDate")
    List<Client> findByStartDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select d FROM Deal d WHERE d.startDate >= :date")
    List<Client> findFromStartDate(@Param("date") Date date);

    @Query("select d FROM Deal d WHERE d.startDate <= :date")
    List<Client> findToStartDate(@Param("date") Date date);

    @Query("select d FROM Deal d WHERE d.endDate = :date")
    List<Client> findByEndDate(@Param("date") Date date);

    @Query("select d FROM Deal d WHERE d.endDate >= :startDate and d.endDate <= :endDate")
    List<Client> findByEndDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select d FROM Deal d WHERE d.endDate >= :date")
    List<Client> findFromEndDate(@Param("date") Date date);

    @Query("select d FROM Deal d WHERE d.endDate <= :date")
    List<Client> findToEndDate(@Param("date") Date date);
}
