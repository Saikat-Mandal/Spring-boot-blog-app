package com.saikat.blogApp.services;


import com.saikat.blogApp.exceptions.ResourceNotFoundException;
import com.saikat.blogApp.models.Category;
import com.saikat.blogApp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

//    create
    public Category createCategory(Category category){
        repo.save(category);
        return category;
    }

//    read all categories
    public List<Category> getAllCategories(){
        return repo.findAll();
    }

//    read category by id
    public Category getCategoryById(int categoryId){
        Category cat = repo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category" , "id" , categoryId));
        return cat;
    }


//    update
    public Category updateCategory(Category category , int categoryId){
        Category foundCategory = repo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category" , "id" , categoryId));
        foundCategory.setCategoryId(category.getCategoryId());
        foundCategory.setCategoryDescription(category.getCategoryDescription());
        foundCategory.setCategoryTitle(category.getCategoryTitle());
        repo.save(foundCategory);

        return foundCategory;
    }

//    delete
    public void deleteCategory(int categoryId){
        Category foundCategory = repo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category" , "id" , categoryId));
        repo.delete(foundCategory);
    }
}
