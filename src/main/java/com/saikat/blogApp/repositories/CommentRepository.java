package com.saikat.blogApp.repositories;

import com.saikat.blogApp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommentRepository extends JpaRepository<Comment , Integer> {
}
