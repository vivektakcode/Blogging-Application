package com.vivektakcode.blog.services;

import java.util.List;

import com.vivektakcode.blog.models.User;
import com.vivektakcode.blog.payload.UserDTO;

public interface UserService {

	
	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user, Integer userId);
	UserDTO getUser(Integer userId);
	List<UserDTO> getAllUsers();
	void deleteUser(Integer userId);
	
	
}
