package com.saikat.blogApp.repositories;

import com.saikat.blogApp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Integer> {
}
