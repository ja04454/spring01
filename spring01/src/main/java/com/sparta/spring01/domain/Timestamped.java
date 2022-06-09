package com.sparta.spring01.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass //이 클래스를 상속하면 멤버 변수가 있을텐데 컬럼으로 인식해줘~
@EntityListeners(AuditingEntityListener.class) //Entity를 주시해라. 뭔가 수정이 일어날 때 자동으로 반영해줘!
public abstract class Timestamped {
    @CreatedDate
    private LocalDateTime createdAt; //LocalDateTime -> 시간을 나타내는 자바의 자료형 중 하나

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}