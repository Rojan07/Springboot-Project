package com.example.teacher.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teacher.teacher.model.Library;
import com.example.teacher.teacher.repo.LibraryRepo;


@Service
public class LibraryServices {
	@Autowired
	LibraryRepo LibraryRepo;
	
	public Library saveLibrary(Library teacher) {
		Library tech=LibraryRepo.save(teacher);
		return tech;
	}
	
	public List<Library> saveLibraries(List<Library> teachers){
		List<Library> tech=LibraryRepo.saveAll(teachers);
		return tech;
		
	}
	
	
	public List<Library> getAllLibraries(){
		List<Library> list = LibraryRepo.findAll();
		return list;
	}
	
	public Library getLibraryById(int id) {
		Library t= LibraryRepo.findById(id).get();
		return t;
			}
	
		public Library getByLibraryName(String name) {
			Library t1= LibraryRepo.findLibraryByName(name);
				      return t1;
			}		
			
			public void deleteLibrary(int id) {
				LibraryRepo.deleteById(id); 
				
			}
	}


