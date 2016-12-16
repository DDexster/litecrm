package com.litecrm.entities.client;

import com.litecrm.entities.lead.Lead;
import com.litecrm.entities.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 16.12.16.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Client c WHERE c.head = :head")
    boolean isExist(@Param("head") Lead head);

    @Query("select c FROM Client c WHERE :person member of c.contacts")
    List<Client> findByContact(@Param("person") Person person);

    @Query("select distinct c FROM Client c WHERE c.head = :head")
    Client findByContact(@Param("head") Lead head);

    @Query("select c FROM Client c WHERE c.companyName = :company")
    List<Client> findByCompanyName(@Param("company") String company);

    @Query("select c FROM Client c WHERE c.country = :country")
    List<Client> findByCountry(@Param("conuntry") String country);

    @Query("select c FROM Client c WHERE c.indTaxNum = :taxNumber")
    List<Client> findByTaxNumber(@Param("taxNumber") int taxNumber);

    @Query("select c FROM Client c WHERE c.taxLicenseNum = :licenseNumber")
    List<Client> findByLicenseNumber(@Param("licenseNumber") int licenseNumber);

    @Query("select c FROM Client c WHERE c.bankAccount = :account")
    List<Client> findByBankAcconut(@Param("account") long account);

    @Query("select c FROM Client c WHERE c.bankCode = :bankCode")
    List<Client> findByBankCode(@Param("bankCode") int bankCode);

    @Query("select c FROM Client c WHERE c.initDate = :date")
    List<Client> findByInitDate(@Param("date") Date date);

    @Query("select c FROM Client c WHERE c.initDate >= :start AND c.initDate <= :endDate")
    List<Client> findByInitDate(@Param("start") Date start, @Param("endDate") Date endDate);

    @Query("select c FROM Client c WHERE c.initDate >= :date")
    List<Client> findFromInitDate(@Param("date") Date date);

    @Query("select c FROM Client c WHERE c.initDate <= :date")
    List<Client> findToInitDate(@Param("date") Date date);
}
