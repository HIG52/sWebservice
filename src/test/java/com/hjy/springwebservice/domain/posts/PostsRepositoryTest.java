package com.hjy.springwebservice.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        /*
        이후 테스트 코드에 영향을 끼치지 않기 위해
        테스트 메소드가 끝날때마다 repository 전체 비우는 코드
         */
        postsRepository.deleteAll();
    }
    @Test
    public void Save_loading(){
        //given
        postsRepository.save(Posts.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("테스트 작성자")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo("테스트 제목");
        assertThat(posts.getContent()).isEqualTo("테스트 내용");
        assertThat(posts.getAuthor()).isEqualTo("테스트 작성자");
    }
}