package com.uniovi.quizapp.config.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.logic.api.IUserManagement;
import com.uniovi.quizapp.service.dto.UserDto;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserManagement userManagement;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    BCryptPasswordEncoder encoder = passwordEncoder();
	    //Collection<? extends GrantedAuthority> auths = new ArrayList<>();
	    //User user = new User("admin", "password", auths);
	    UserDto user = userManagement.getUser(username);
	    if(user == null){
	        throw new UsernameNotFoundException("User Name "+username +"Not Found");
	    }
	    return new org.springframework.security.core.userdetails.User(user.getUsername(),encoder.encode(user.getPassword()),getGrantedAuthorities(user));
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	private Collection<GrantedAuthority> getGrantedAuthorities(UserDto user){

	    Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
	    
	    /*if(user.getRole().getName().equals("admin")){
	        grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	    }*/
	    
	    grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
	    return grantedAuthority;
	}

}
