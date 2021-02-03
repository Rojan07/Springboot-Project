package com.example.teacher.teacher.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.teacher.teacher.model.DaoUser;
import com.example.teacher.teacher.model.UserDto;
import com.example.teacher.teacher.repo.DaoUserRepo;
import com.example.teacher.teacher.repo.UserRepo;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private DaoUserRepo daoUserRepo;
	
	@Autowired
	private PasswordEncoder BCryptPasswordEncoder;
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		DaoUser user = daoUserRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}


	
	
	//JWT authentication using database


	public DaoUser save(UserDto user) {
	DaoUser newUser = new DaoUser();
	newUser.setUsername(user.getUsername());
		newUser.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));
	return daoUserRepo.save(newUser);
	}
}
	
	
	
//JWT AUTHENTICATION USING HARDCORE VALUES
//@Override
//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	if ("rojan".equals(username)) {
//		return new User("rojan", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//				new ArrayList<>());
//	} else {
//		throw new UsernameNotFoundException("User not found with username: " + username);
//	}
//}
	

  

	



//simple authentication using database
	
//
//		User user = userrepo.findUserByUsername(username);
//		NewUserDetails userDetails;
//
//		if (user != null) {
//			userDetails = new NewUserDetails();
//			userDetails.setUser(user);
//
//		} else {
//
//			throw new UsernameNotFoundException("User not found with name :" + username);
//		}
//		return userDetails;
//
//	}


