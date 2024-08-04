package com.saikat.blogApp.repositories;

import com.saikat.blogApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
