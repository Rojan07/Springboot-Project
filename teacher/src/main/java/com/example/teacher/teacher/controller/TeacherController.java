package com.example.teacher.teacher.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.teacher.teacher.exception.ResourceNotFoundException;
import com.example.teacher.teacher.model.TeacherModel;
import com.example.teacher.teacher.model.User;
import com.example.teacher.teacher.service.TeacherServices;
import com.google.common.io.Files;

import io.swagger.models.Path;

import com.example.teacher.teacher.model.Response;

@RestController
@RequestMapping("/api")

public class TeacherController {

	@Autowired
	TeacherServices ts;

	// crud
	@PostMapping("/save")
	public TeacherModel saveTeacher(@RequestBody TeacherModel t) {
		System.out.print("save teacher record");
		TeacherModel tu = ts.saveTeacher(t);
		return tu;
	}

	@PostMapping("/add")
	public List<TeacherModel> addTeacher(@RequestBody List<TeacherModel> teachers) {
		List<TeacherModel> Teacherlist = ts.saveTeachers(teachers);
		return Teacherlist;

	}

	@GetMapping("/get")
	public List<TeacherModel> getAllTeacher() {
		List<TeacherModel> list = ts.getAllTeacher();
		return list;

	}

	@GetMapping("/pick/{id}")
	public TeacherModel getTeacherById(@PathVariable("id") int id) {
		TeacherModel teach = ts.getTeacherById(id);
		return teach;
	}

	@GetMapping("/go/{name}")
	public TeacherModel getTeacherByName(@PathVariable("name") String name) {
		TeacherModel teachname = ts.getByTeacherName(name);
		return teachname;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTeacher(@PathVariable("id") int id) {
		ts.deleteTeacher(id);
	}

	// filehandling

	@PostMapping("/uploadFile")
	public Response uploadFile(@RequestParam("file") MultipartFile file) {
		TeacherModel name = ts.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(name.getName())
				.toUriString();

		return new Response(name.getName(), fileDownloadUri, file.getContentType(), file.getSize());
	}

	@PostMapping("/uploadMultipleFiles")
	public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}

	@GetMapping("/downloadFile/{fileId}")
	public Optional<TeacherModel> downloadFile(@PathVariable Integer fileId) {
		// Load file as Resource
		Optional<TeacherModel> databaseFile = ts.getFile(fileId);
		return databaseFile;

	}




}





//
//	@PostMapping("/uploadfiles")
//	public String  uploadFile(@RequestParam MultipartFile file) {
//		
//		

//		System.out.println(file.getName());
//		System.out.println(file.getContentType());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		

//		try {
//		
//		if(file.isEmpty()) {
//			throw new ResourceNotFoundException("request must contain a file");
//		}
//		
//		boolean f=ts.uploadfile(file);
//		if(f) {
//			return "File uploaded successfully";
//		}
//		
//		
//		} catch (Exception e) {
//			 e.printStackTrace();
//		}
//	
//
//		
//		 throw new ResourceNotFoundException("Sorry");
//	}
//}
