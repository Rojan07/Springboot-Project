package com.example.teacher.teacher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teacher.teacher.model.DaoUser;

public interface DaoUserRepo extends JpaRepository<DaoUser, Long>{
	
 DaoUser findByUsername (String username);

}
