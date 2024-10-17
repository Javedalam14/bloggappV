package com.blogapp12.blogapp.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data

public class PostDto {

    private long id;

    private String title;
    private String description;
    private String content;


    }

