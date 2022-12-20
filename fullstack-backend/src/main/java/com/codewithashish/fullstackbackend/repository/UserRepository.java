package com.codewithashish.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithashish.fullstackbackend.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
