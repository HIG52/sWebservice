package com.hjy.springwebservice.domain.posts;

import com.hjy.springwebservice.dto.PostsMainResponseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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



/*테스트 코드 나중에 작성하기
    @Test
    @DisplayName("저장된 멤버가 제대로 조회 되는지 확")
    public void posts_list(){
        //given
        String title = "테스트 제목";
        String content = "테스트 내용";

        postsRepository.save(Posts.builder()
                .title(title).content(content).author("test").build()); //빌더패턴 사용

        //when
        List<Posts> list = (List<Posts>) postsRepository.findAllDesc();

        //then
        Posts posts = list.get(0);
        assertThat(posts.getTitle()).isEqualTo("테스트 제목");
        assertThat(posts.getContent()).isEqualTo("테스트 내용");
        assertThat(posts.getAuthor()).isEqualTo("test");

    }
*/

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

    @Test
    public void BaseTimeEntity_save(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("테스트 작성자")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}