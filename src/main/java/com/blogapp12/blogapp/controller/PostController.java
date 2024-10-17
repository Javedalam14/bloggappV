package com.blogapp12.blogapp.controller;


import com.blogapp12.blogapp.payload.PostDto;
import com.blogapp12.blogapp.service.PostService;
import com.blogapp12.blogapp.service.impl.PostServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Data
@RestController
@RequestMapping("/api/posts")
public class PostController {


    @Autowired
    private PostService postService;

//  http://localhost/8081/api/posts
       @PostMapping
        public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
          PostDto dto=  postService.createPost(postDto);
          return new ResponseEntity<>(dto, HttpStatus.CREATED);

        }
    }


