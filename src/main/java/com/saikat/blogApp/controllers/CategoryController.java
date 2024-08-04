package com.saikat.blogApp.controllers;


import com.saikat.blogApp.models.Category;
import com.saikat.blogApp.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService service;

//    create a new category
    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){

        Category createdCategory = service.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }


//    get all categories
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> res = service.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

//    get a specific category by id
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId){
        Category gotCategory = service.getCategoryById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(gotCategory);
    }

//    update category by id
    @PutMapping("/category/{categoryId}")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category , @PathVariable int categoryId){
        Category updatedCategory = service.updateCategory(category ,categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }

//    delete a category by id
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable int categoryId){
        service.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
