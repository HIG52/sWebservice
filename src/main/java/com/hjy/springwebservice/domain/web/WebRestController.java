package com.hjy.springwebservice.domain.web;

import com.hjy.springwebservice.domain.posts.PostsRepository;
import com.hjy.springwebservice.dto.posts.PostsSaveRequestDto;
import com.hjy.springwebservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    //private PostsRepository postsRepository;
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        //postsRepository.save(dto.toEntity());
        return postsService.save(dto);
    }
}
