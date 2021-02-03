package com.example.teacher.teacher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teacher.teacher.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findUserByUsername(String username);

}
