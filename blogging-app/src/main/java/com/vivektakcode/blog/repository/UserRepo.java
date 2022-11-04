package com.vivektakcode.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivektakcode.blog.models.User;



/*Here the UserRepo is an interface but it's objects has been created using the Autowired annotation
 * This is happening because at runtime the Spring Container looks up for the interface and dynamically creates proxy classes
 * for the interfaces whose classes have not been created
 * So, proxy class is created for this interface and thus  we can use its object  without creating its class
 * 
 * */
public interface UserRepo extends JpaRepository<User, Integer>{

}
