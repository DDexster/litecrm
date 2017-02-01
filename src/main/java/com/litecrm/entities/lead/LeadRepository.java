package com.litecrm.entities.lead;

import com.litecrm.entities.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by ddexster on 13.12.16.
 */
public interface LeadRepository extends JpaRepository<Lead, Long> {
    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END FROM Lead l WHERE p.contact = :person")
    boolean isExist(@Param("person") Person person);

    @Query("SELECT distinct l from Lead l WHERE l.contact = :contact")
    Lead findByPerson(@Param("contact") Person person);

    @Query("SELECT l from Lead l where l.initiationDate =:date")
    List<Lead> findByInitiationDate(@Param("date") Date date);

    @Query("SELECT l from Lead l where l.initiationDate >= :start and l.initiationDate <= :endDate")
    List<Lead> findByInitiationDate(@Param("start") Date start, @Param("endDate") Date endDate);

    @Query("select l from Lead l where l.initiationDate >= :date")
    List<Lead> findFromInitiationDate(@Param("date") Date date);

    @Query("select l from Lead l where l.initiationDate <= :date")
    List<Lead> findToInitiationDate(@Param("date") Date date);

    @Query("select l from Lead l where l.companyName = :company")
    List<Lead> findByCompanyName(@Param("company") String company);

    @Query("select l from Lead l where :interest member OF l.interests")
    List<Lead> findByInterest(@Param("interest") String interest);

//    @Query("select l from Lead l where any of :interests member of l.interests")
//    List<Lead> findByInterests(Collection<String> interests);
}
