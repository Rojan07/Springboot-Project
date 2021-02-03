package com.example.teacher.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teacher.teacher.model.Library;

import com.example.teacher.teacher.service.LibraryServices;

@RestController
@RequestMapping("/chelsea")
public class LibraryController {

	@Autowired
	LibraryServices LibraryServices;

	@PostMapping("/mendy")
	public Library saveLibrary(@RequestBody Library t) {
		System.out.print("save library record");
		Library tu = LibraryServices.saveLibrary(t);
		return tu;
	}

	@PostMapping("/cech")
	public List<Library> addLibraries(@RequestBody List<Library> teachers) {
		List<Library> librarylist = LibraryServices.saveLibraries(teachers);
		return librarylist;

	}

	@GetMapping("/assistant")
	public List<Library> getAllLibraries() {
		List<Library> list = LibraryServices.getAllLibraries();
		return list;
	}

	@GetMapping("/coach/{id}")
	public Library getLibraryById(@PathVariable("id") int id) {
		Library teach = LibraryServices.getLibraryById(id);
		return teach;

	}

	@GetMapping("/pulisic/{name}")
	public Library getLibraryById(@PathVariable("name") String name) {
		Library teachname = LibraryServices.getByLibraryName(name);
		return teachname;
	}

	@DeleteMapping("/manager/{id}")
	public void deleteLibrary(@PathVariable("id") int id) {
		LibraryServices.deleteLibrary(id);
	}
}
