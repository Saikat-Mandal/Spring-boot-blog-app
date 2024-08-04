package com.saikat.blogApp.repositories;

import com.saikat.blogApp.models.Category;
import com.saikat.blogApp.models.Post;
import com.saikat.blogApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
