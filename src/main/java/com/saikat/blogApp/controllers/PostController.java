package com.saikat.blogApp.controllers;


import com.saikat.blogApp.models.Post;
import com.saikat.blogApp.payloads.PostResponse;
import com.saikat.blogApp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService service;

//    create a post
        @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post , @PathVariable int userId , @PathVariable int categoryId ){
        Post createdPost = service.createPost(post ,userId ,categoryId );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

//    get a single post by post id
    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> getPostsById(@PathVariable int postId){
        Post post = service.getPostById(postId);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

//    get all posts
    @GetMapping("/post")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber" , defaultValue = "0" , required = false) int pageNumber,
            @RequestParam(value = "pageSize" , defaultValue = "2" , required = false) int pageSize
             ){
        PostResponse postResponse =  service.getAllPosts(pageNumber , pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(postResponse);
    }

//    get posts by user id

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable int userId){
        List<Post> posts = service.getPostsByUser(userId);

        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

//    get posts by category id
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable int categoryId){
        List<Post> posts = service.getPostsByCategory(categoryId);

        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

//    update post by id
    @PutMapping("/post/{postId}")
    public ResponseEntity<Post> updatePost( @RequestBody Post post , @PathVariable int postId){
        Post updatePost = service.updatePostById(post, postId);

        return ResponseEntity.status(HttpStatus.OK).body(updatePost);
    }

//    delete a post by post id
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable int postId){
        service.deletePostById(postId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
