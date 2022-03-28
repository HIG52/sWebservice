package com.hjy.springwebservice.service;

import com.hjy.springwebservice.domain.posts.PostsRepository;
import com.hjy.springwebservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    /*호출한쪽에서 저장한 게시글의 id를 알수있게 리턴타입을 Long으로 두고 .getId()를 반환값으로 한다.
    Service 메소드는 Entity를 바로 받지 않고 이전에 생성한 Save용 DTO인 PostsSaveRequestDto를 받아서 저장한다.
    Controller에서 Dto.toEntity를 통해서 바로 전달해도 되는데 굳이 Service에서 Dto를 받는 이유는
    Controller와 Service의 역할을 분리하기 위함이다.
    비지니스 로직 & 트랜잭션 관리는 모두 Service에서 관리하고 View와 연동되는 부분은 Controller에서 담당하도록 구성한다.
     */
    /*
    트랜잭션
    일반적으로 DB데이터를 등록/수정/삭제 하는 Service 메서드는 @Transactional를 필수적으로 자겨간다.
    이 어노테이션이 하는일은 간단한데
    메서드 내에서 Exception이 발생하면 해당 메서드에서 이루어진 모든 DB작업을 초기화 시킨다.
    즉 save 메서드를 통해서 10개를 등록해야하는데 5번째에서 Exception이 발생하면 앞에 저장된 4개까지를 전부 롤백 시킨다.
    (정확히는 이미 넣은걸 롤백시키는것이 아니라 모든 처리가 정상적으로 끝나야 DB에 커밋하고 아니면 커밋하지 않는것이다.)

     */
    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}
