package com.gridscape.userserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gridscape.exceptions.NoUserFoundException;
import com.gridscape.models.Organization;
import com.gridscape.models.User;
import com.gridscape.repositories.UserRepo;
import com.gridscape.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo uRepo;
	
	@Override
	public User registerUser(User user) {
		return uRepo.save(user);
	}

	@Override
	public User changeOrganization(Organization org) throws NoUserFoundException {
		Optional<User> userOpt=uRepo.findByEmailId(SecurityContextHolder.getContext().getAuthentication().getName());
		if(userOpt.isPresent()) {
			
			User user=userOpt.get();
			user.setOrg(org);
			return uRepo.save(user);
			
		}
		else
			throw new NoUserFoundException("Login require to change organization");
	}

	@Override
	public List<User> getAllUser() {
		return uRepo.findAll();
	}

}
