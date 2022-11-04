package com.vivektakcode.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivektakcode.blog.exceptions.ResourceNotFoundException;
import com.vivektakcode.blog.models.User;
import com.vivektakcode.blog.payload.UserDTO;
import com.vivektakcode.blog.repository.UserRepo;
import com.vivektakcode.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.dtoToUser(userDTO);
		User savedUser=this.userRepo.save(user);
		return this.userToDTO(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		User updatedUser = this.userRepo.save(user);
		
		UserDTO userDTONew= this.userToDTO(updatedUser);
		return userDTONew;
		
	}

	@Override
	public UserDTO getUser(Integer userID) {
		User user= userRepo.findById(userID).orElseThrow(()-> new ResourceNotFoundException("User", "id", userID));
		return this.userToDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users=userRepo.findAll();
		List<UserDTO> userDTOs=users.stream().map(user-> this.userToDTO(user)).collect(Collectors.toList());
		return userDTOs;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		userRepo.delete(user);
	}
	
	public User dtoToUser(UserDTO userDTO) {
		User user = this.modelMapper.map(userDTO, User.class);
		/*
		 * user.setId(userDTO.getId()); user.setName(userDTO.getName());
		 * user.setEmail(userDTO.getEmail()); user.setPassword(userDTO.getPassword());
		 * user.setAbout(userDTO.getAbout());
		 */
		return user;
	}
	
	public UserDTO userToDTO(User user ) {
		UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
		/*
		 * userDTO.setId(user.getId()); userDTO.setEmail(user.getEmail());
		 * userDTO.setName(user.getName()); userDTO.setPassword(user.getPassword());
		 * userDTO.setAbout(user.getAbout());
		 */
		return userDTO;
		
	}

}
