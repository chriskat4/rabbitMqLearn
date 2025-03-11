package com.rabbitLearning.rabbitLearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rabbitLearning.rabbitLearning.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
}
