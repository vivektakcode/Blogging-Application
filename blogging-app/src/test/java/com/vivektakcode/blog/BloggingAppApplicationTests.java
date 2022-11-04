package com.vivektakcode.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vivektakcode.blog.repository.UserRepo;

@SpringBootTest
class BloggingAppApplicationTests {
	
	@Autowired
	UserRepo userRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getClassName() {
		String className = this.userRepo.getClass().getName();
		String packageName = this.userRepo.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packageName);
	}

}
