package com.springjpa.dao;

import com.springjpa.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    /**
     By Default from CrudRepository Methods:
        getAllById
        findById
        findAll etc....

     Derived Query methods/Custom Finder Methods:
        Data by name
        Data by name and city
        Data by name or status/password..
        Data name starting with prefix
        Data by name like 'keyword'

      Ex:
         findByAgeGreaterThanEqual(int age)
         findByAgeIn(Collection<Integer> ages)
         findByNameOrderByName(String name)

     @Query:
        JPQL query
        Native query
     */
//    Custom Finder Methods Should be Camel Case
    public List<User> findByName(String name);

    public List<User> findByNameAndCity(String name, String city);

//    Executing JPQL and Native Queries
    @Query("select u from User u ")
    public List<User> getAllUser();

    @Query("select p from User p where p.name =:r and p.status =:s")
    public List<User> getUserByName(@Param("r") String name,@Param("s") String status);

//    Native Queries
    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();


}
