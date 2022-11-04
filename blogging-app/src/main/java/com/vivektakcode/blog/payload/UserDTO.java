 package com.vivektakcode.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

	private Integer id;
	
	@NotEmpty
	@Size(min =4, message="username must be atleast 4 characters")
	private String name;
	
	@Email(message="Email address is not valid!!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message="Password length unjustified")
	private String password;
	@NotEmpty
	private String about;
	
	
	
}
