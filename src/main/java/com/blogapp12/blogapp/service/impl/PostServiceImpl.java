package com.blogapp12.blogapp.service.impl;

import com.blogapp12.blogapp.entity.Post;
import com.blogapp12.blogapp.payload.PostDto;
import com.blogapp12.blogapp.repository.PostRepository;
import com.blogapp12.blogapp.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

   private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto){
        // convert into Dto to Entity
        Post post = new Post();
        String dtoTitle=postDto.getTitle();
        post.setTitle(dtoTitle);
        String dtoDescription=postDto.getDescription();
        post.setDescription(dtoDescription);
        post.setContent(postDto.getContent());

       Post savePost= postRepository.save(post);// here save in db and whatever data will save method also return back to the data in savePost reference;
        // convert into Dto to Entity

        //Now get data from db and obj convert  Entity to Dto

       PostDto dto=new PostDto();
       dto.setId(savePost.getId());
       dto.setTitle(savePost.getTitle());
       dto.setContent(savePost.getContent());
       dto.setDescription(savePost.getDescription());

        return dto;
    }
}
