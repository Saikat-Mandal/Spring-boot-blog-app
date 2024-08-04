package com.saikat.blogApp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Blog_user ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Size(min=4 , message = "Minimum 4 characters required for username")
    private String name;

    @Email(message = "your email is invalid")
    private String email;

    @NotEmpty
    @Size(min=3 , max = 5 , message = "Password min length must be 3 and max length must be 5")
    private String password;

    @NotEmpty
    private String about;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();

}
