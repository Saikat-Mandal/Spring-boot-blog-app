package com.saikat.blogApp.payloads;

import com.saikat.blogApp.models.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



public class PostResponse {
    private List<Post> posts;
    private int pageNumber;
    private int pageSize;
    private boolean isLastPage;
    private long totalElements;
    private int totalPages;

    // Constructors
    public PostResponse() {}

    public PostResponse(List<Post> posts, int pageNumber, int pageSize, long totalElements , int totalPages, boolean isLastPage) {
        this.posts = posts;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.isLastPage = isLastPage;
        this.totalPages = totalPages;

    }

    // Getters and Setters
    public List<Post> getPosts() {
        return posts;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }
}

