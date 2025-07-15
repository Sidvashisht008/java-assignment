package com.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entity.UserEntity;
import com.user.service.exception.EmailAlreadyExistsException;
import com.user.service.exception.UserNotFoundException;
import com.user.service.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.userRepo = repo;
	}
	
	public UserEntity createUser(UserEntity user) {
		if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }
		return userRepo.save(user);
	}

	public UserEntity getUserById(Long userId) {
		Optional<UserEntity> user = userRepo.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException(userId);
		}
		return user.get();
		
	}

	public String deleteUserById(Long userId) {
		if (!userRepo.existsById(userId)) {
	        throw new UserNotFoundException(userId);
	    }
		userRepo.deleteById(userId);
		return "User successfully deleted";
	}
	
	public UserEntity updateUser(Long userId, UserEntity updatedUser) {
		Optional<UserEntity> user = userRepo.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException(userId);
		}
		UserEntity existingUser = user.get();
		boolean isEmailChanged = !existingUser.getEmail().equals(updatedUser.getEmail());
	    boolean emailExists = userRepo.findByEmail(updatedUser.getEmail()).isPresent();

	    if (isEmailChanged && emailExists) {
	        throw new EmailAlreadyExistsException(updatedUser.getEmail());
	    }
	    existingUser.setFirstName(updatedUser.getFirstName());
	    existingUser.setLastName(updatedUser.getFirstName());
	    existingUser.setEmail(updatedUser.getEmail());
	    return userRepo.save(existingUser);
    }

}
