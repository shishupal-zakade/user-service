package com.microservices.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.example.entiry.User;

@Repository
public interface UserRepositiry extends JpaRepository<User, Long> {

}
