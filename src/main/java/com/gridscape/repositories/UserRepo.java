package com.gridscape.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gridscape.models.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	
	public Optional<User> findByEmailId(String emailId);
	
}
