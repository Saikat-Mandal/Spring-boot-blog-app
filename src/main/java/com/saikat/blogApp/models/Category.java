package com.saikat.blogApp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name="title" , length = 100 , nullable = false)
    @NotEmpty
    @Size(min=4)
    private String categoryTitle;

    @Column(name="description")
    @NotEmpty
    @Size(min=10)
    private String categoryDescription;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();
}
