package com.hjy.springwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//ibatis/Mybatis 등에서 Dao라고 불리느 DB Layer접근자
//JPA에선 Repository라고 부르며 인터페이스로 생성
//단순히 인터페이스를 생성후 JpaRepository<Entity클래스, PK타입>를 상속하면 기본적인 CRUD메소드가 자동으로 생성됨
//특별히 @Repository를 추가할필요도 없음
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
