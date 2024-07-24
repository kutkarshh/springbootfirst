package com.myspringboot.springbootfirst.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.myspringboot.springbootfirst.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    // Fetch users by name
     public List<User> findByName(String name);

    // Fetch users by status
    public List<User> findByStatus(String status);

    // Fetch all users
    @Query("select u from User u")
    public List<User> getAllUsers();

    // Fetch users by name and city
    @Query("select u from User u where u.name =:n and u.city =:c")
    public List<User> getUserByNameNCity(@Param("n") String name, @Param("c") String c);

    // Fetch users using native query
    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsersList();
}
