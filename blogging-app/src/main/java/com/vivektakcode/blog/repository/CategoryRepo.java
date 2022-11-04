package com.vivektakcode.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivektakcode.blog.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
