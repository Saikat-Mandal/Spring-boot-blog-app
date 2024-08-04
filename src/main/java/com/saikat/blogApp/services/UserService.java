package com.saikat.blogApp.services;

import com.saikat.blogApp.exceptions.ResourceNotFoundException;
import com.saikat.blogApp.models.User;
import com.saikat.blogApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

   @Autowired
   private UserRepository repo;

   public User createUser(User user){
      repo.save(user);
      return user;
   }

   public User updateUser(User user , int userId){
      User foundUser = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", " id " , userId));

      foundUser.setName(user.getName());
      foundUser.setEmail(user.getEmail());
      foundUser.setPassword(user.getPassword());
      foundUser.setAbout(user.getAbout());

      repo.save(foundUser);

      return user;
   }

   public User getUserById(int userId){
      User user = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", " id " , userId));
      return user;
   }

   public List<User> getAllUsers(){
      return repo.findAll();
   }

   public void deleteUser(int userId){
      User user = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", " id " , userId));
      repo.delete(user);
   }
}
