package com.saikat.blogApp.services;

import com.saikat.blogApp.exceptions.ResourceNotFoundException;
import com.saikat.blogApp.models.Comment;
import com.saikat.blogApp.models.Post;
import com.saikat.blogApp.models.User;
import com.saikat.blogApp.repositories.CommentRepository;
import com.saikat.blogApp.repositories.PostRepository;
import com.saikat.blogApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;

    public Comment createComment(Comment comment , int postId , int userId){
        Post post = postRepo.findById(postId).orElseThrow(()->  new ResourceNotFoundException("Post" , "post id" , postId));
        User user = userRepo.findById(postId).orElseThrow(()->  new ResourceNotFoundException("User" , "user id" , userId));
        comment.setPost(post);
        comment.setUser(user);
        Comment savedComment = repo.save(comment);
        return savedComment;
    }

    public void deleteComment(int commentId){
        repo.deleteById(commentId);
    }

}
