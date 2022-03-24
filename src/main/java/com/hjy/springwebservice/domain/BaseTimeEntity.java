package com.hjy.springwebservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//이 클래스는 모든 Entity들의 상위 클래스가 되어 Entity들의 createdDate, ModifiedDate를 자동으로 관리하는 역할
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime creatDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
