package com.gridscape.userservice;

import java.util.List;

import com.gridscape.exceptions.NoUserFoundException;
import com.gridscape.models.Organization;
import com.gridscape.models.User;

public interface UserService {
	
	public User registerUser(User user);
	
	public User changeOrganization(Organization org) throws NoUserFoundException;
	
	public List<User> getAllUser();
	
}
