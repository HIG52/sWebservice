package com.hjy.springwebservice.web;

import com.hjy.springwebservice.domain.posts.PostsRepository;
import com.hjy.springwebservice.dto.posts.PostsRepositoryDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsRepositoryDto dto){
        postsRepository.save(dto.toEntity());
    }
}
