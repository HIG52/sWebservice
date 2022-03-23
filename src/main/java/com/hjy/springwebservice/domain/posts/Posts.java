package com.hjy.springwebservice.domain.posts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //이 Posts클래스는 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity클래스라고도 한다.
    //JPA를 사용하면 DB데이터에 작업할 경우 실제 쿼리를 날리기 보다는, 이 Entity클래스의 수정을 통해 작업한다.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
