package com.vivektakcode.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vivektakcode.blog.payload.ApiResponse;
import com.vivektakcode.blog.payload.UserDTO;
import com.vivektakcode.blog.services.UserService;

@RestController
@RequestMapping("/apis/user")
public class UserController {
	
	//POST -create user
	//GET -get User
	//PUT -update User
	//DELETE -delete User
	
	@Autowired
	private UserService userServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
		
		UserDTO createdUserDTO=this.userServiceImpl.createUser(userDTO);
		return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
		}
	
	@RequestMapping(value="/{userID}", method=RequestMethod.PUT)
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer userID){
		UserDTO updatedUser=this.userServiceImpl.updateUser(userDTO, userID);
		return ResponseEntity.ok(updatedUser);	
	}
	
	@RequestMapping(value="/{userID}",method= RequestMethod.DELETE)
	public ResponseEntity<ApiResponse> deleteUser(@RequestBody @PathVariable("userID") Integer userID){
		this.userServiceImpl.deleteUser(userID);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}
	
	@GetMapping(value="/{userID})")
	public ResponseEntity<UserDTO> getSingleUser(@RequestBody @PathVariable("userID") Integer UserID)
	{
		UserDTO getUser= this.userServiceImpl.getUser(UserID);
		return ResponseEntity.ok(getUser);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(this.userServiceImpl.getAllUsers());
	}
	
	
	

}
