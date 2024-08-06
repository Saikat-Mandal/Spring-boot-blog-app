package com.saikat.blogApp.controllers;


import com.saikat.blogApp.models.Comment;
import com.saikat.blogApp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping("/user/{userId}/post/{postId}/comment")
    private ResponseEntity<Comment> createComment(@RequestBody Comment comment ,
                                         @PathVariable int postId ,
                                         @PathVariable int userId){
        Comment createdComment = service.createComment(comment , postId , userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable int commentId){
        service.deleteComment(commentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
