package com.litecrm.entities.person;

import com.litecrm.entities.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Person p WHERE p.email = :email")
    boolean isExist(@Param("email") String email);

    @Query("SELECT p FROM Person p WHERE p.firstName = :name")
    List<Person> findByName(@Param("name") String name);

    @Query("SELECT p FROM Person p WHERE p.lastName = :lastName")
    List<Person> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT p FROM Person p WHERE :phone MEMBER OF p.phones ")
    List<Person> findByPhone(@Param("phone") String phone);

    @Query("SELECT distinct p FROM Person p WHERE p.email = :email")
    Person findByEmail(@Param("email") String email);

    @Query("SELECT p FROM Person p WHERE p.type = :personType")
    List<Person> findByType(@Param("personType") ContactType type);

    @Query("SELECT p FROM Person p WHERE p.birthDate = :birthDate")
    List<Person> findByBirthDate(@Param("birthDate") Date birthDate);

    @Query("SELECT p FROM Person p WHERE p.birthDate >= :birthDate")
    List<Person> findFromBirthDate(@Param("birthDate") Date birthDate);

    @Query("SELECT p FROM Person p WHERE p.birthDate <= :birthDate")
    List<Person> findToBirthDate(@Param("birthDate") Date birthDate);

    @Query("SELECT p FROM Person p WHERE p.birthDate >= :startDate AND p.birthDate <= :endDate")
    List<Person> findByBirthDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


}
