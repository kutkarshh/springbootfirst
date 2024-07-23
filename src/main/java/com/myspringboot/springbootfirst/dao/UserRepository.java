package com.myspringboot.springbootfirst.dao;

import org.springframework.data.repository.CrudRepository;

import com.myspringboot.springbootfirst.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
