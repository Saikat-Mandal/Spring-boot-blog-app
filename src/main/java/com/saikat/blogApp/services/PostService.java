package com.saikat.blogApp.services;


import com.saikat.blogApp.exceptions.ResourceNotFoundException;
import com.saikat.blogApp.models.Category;
import com.saikat.blogApp.models.Post;
import com.saikat.blogApp.models.User;
import com.saikat.blogApp.payloads.PostResponse;
import com.saikat.blogApp.repositories.CategoryRepository;
import com.saikat.blogApp.repositories.PostRepository;
import com.saikat.blogApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CategoryRepository categoryRepo;



//    create post
    public Post createPost(Post post , int userId , int categoryId){

        User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", " id " , userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", " id " , categoryId));

        post.setImageName("defaultImage.jpg");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savedPost = repo.save(post);

        return savedPost;
    }

//    read
    public Post getPostById(int postId){
        Post gotPost = repo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post" , "id" , postId));
        return gotPost;
    }

//    read all posts
    public PostResponse getAllPosts(int pageNo , int pageSize , String sortBy , String sortDir ){

        Sort sort = null;
        if(sortDir.equalsIgnoreCase("asc")){
            sort = Sort.by(sortBy).ascending();
        }
        else{
            sort  = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize , sort);
        Page<Post> pagePost = repo.findAll(pageable);
        List<Post> posts = pagePost.getContent();

        PostResponse postResponse = new PostResponse();

        postResponse.setPosts(posts);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());

        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }

//    update
    public Post updatePostById(Post post , int postId){
        Post gotPost = repo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post" , "id" , postId));

        gotPost.setTitle(post.getTitle());
        gotPost.setContent(post.getContent());
        gotPost.setImageName(post.getImageName());

        Post updatedPost = repo.save(gotPost);
        return updatedPost;
    }

//    delete
    public void deletePostById(int postId){
        Post gotPost = repo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post" , "id" , postId));
        repo.delete(gotPost);
    }

//    get all posts by category
    public List<Post> getPostsByCategory(int categoryId){
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category" , "id" , categoryId));
        List<Post> posts = repo.findByCategory(category);

        return posts;
    }


//    get all posts by user
    public List<Post> getPostsByUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user" , "id" , userId));
        List<Post> posts = repo.findByUser(user);
        return posts;
    }

//    search a post
    public List<Post> searchPost(String keyword){
        List<Post> posts = repo.findByTitleContaining(keyword);
        return posts;
    }



}

