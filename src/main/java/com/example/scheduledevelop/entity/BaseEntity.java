package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 상속받는 Entity에 공통 매핑 정보 제공
@EntityListeners(AuditingEntityListener.class) //Entity를 DB에 적용하기 전, 커스텀 콜백
public class BaseEntity {

    @CreatedDate // 생성 시점 자동 기록
    @Column(updatable = false) // 생성일은 최초 등록만 하면 되기때문에 최신화 필요가 없음
    @Temporal(TemporalType.TIMESTAMP) // 날짜 세부타입 지정 ※ 생략가능
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정 시점 자동 기록
    @Temporal(TemporalType.TIMESTAMP) // 날짜 세부타입 지정 ※ 생략가능
    private LocalDateTime updatedAt;

}
