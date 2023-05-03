package com.gridscape.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gridscape.models.User;
import com.gridscape.repositories.UserRepo;


@Service
public class UserDetailsServiceClass implements UserDetailsService{
	
	@Autowired
	private UserRepo urepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt= urepo.findByEmailId(username);
		if(opt.isPresent()) {
			
			User user=opt.get();
			
			List<GrantedAuthority> authorities=new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			
			return new org.springframework.security.core.userdetails.User(user.getEmailId(),user.getPassword(),authorities);
			
		}
		else 
			throw new UsernameNotFoundException("No user found with username "+username);
	}

}
