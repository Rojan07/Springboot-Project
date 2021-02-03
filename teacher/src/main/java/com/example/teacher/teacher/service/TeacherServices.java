package com.example.teacher.teacher.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.teacher.teacher.exception.ResourceNotFoundException;
import com.example.teacher.teacher.model.TeacherModel;
import com.example.teacher.teacher.repo.TeacherRepo;

@Service
public class TeacherServices {
	@Autowired
	TeacherRepo teacherrepo;

	public TeacherModel saveTeacher(TeacherModel teacher) {
		TeacherModel tech = teacherrepo.save(teacher);
		return tech;
	}

	public List<TeacherModel> saveTeachers(List<TeacherModel> teachers) {
		List<TeacherModel> tech = teacherrepo.saveAll(teachers);
		return tech;

	}

	public List<TeacherModel> getAllTeacher() {
		List<TeacherModel> list = teacherrepo.findAll();
		return list;
	}

	public TeacherModel getTeacherById(int id) {
		Optional<TeacherModel> t = teacherrepo.findById(id);
		TeacherModel te;
		if (t.isPresent()) {
			te = t.get();
		} else {
			throw new ResourceNotFoundException("The id" + id + " is not found");
		}

		return te;
	}

	public TeacherModel getByTeacherName(String name) {
		Optional<TeacherModel> t1 = teacherrepo.findByName(name);
		TeacherModel te;
		if (t1.isPresent()) {
			te = t1.get();
		} else {
			throw new ResourceNotFoundException(" The name" +name+" is not found");
		}
		return te;
	}

	public void deleteTeacher(int id) {
		teacherrepo.deleteById(id);

	}

	public TeacherModel storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try { 
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new ResourceNotFoundException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			TeacherModel dbFile = new TeacherModel(fileName, file.getContentType(), file.getBytes());

			return teacherrepo.save(dbFile);
		} catch (IOException ex) {
			throw new ResourceNotFoundException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public Optional<TeacherModel> getFile(Integer fileId) {
		
	try {
		return teacherrepo.findById(fileId);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
				throw new ResourceNotFoundException("File not found with id " + fileId);
	}

}

//	public final String UPLOAD_DIR = "C:\\upload";
//
//	public boolean uploadfile(MultipartFile multipartfile) {
//
//		boolean f = false;
//
//		try {
////			InputStream in = multipartfile.getInputStream();
////			byte data[] = new byte[in.available()];
////			in.read(data);
////			
////			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"//"+multipartfile.getOriginalFilename());
////			fos.write(data);
////			fos.close();
//
//			Files.copy(multipartfile.getInputStream(),
//					Paths.get(UPLOAD_DIR + "//" + multipartfile.getOriginalFilename()),
//					StandardCopyOption.REPLACE_EXISTING);
//
//			f = true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}
//}
//
//	}

//
////file handling
//public TeacherModel saveTeacher(MultipartFile file) {
//	String name = file.getOriginalFilename();
//	try {
//		TeacherModel model= new TeacherModel(name, file.getContentType(), file.getBytes());
//		return teacherrepo.save(model);
//	} catch (Exception e) {
//		e.printStackTrace();
//}
//	return null;
//}
