package com.example.teacher.teacher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teacher.teacher.model.Library;

public interface LibraryRepo extends JpaRepository<Library, Integer>{
	Library findLibraryByName(String name);

}
