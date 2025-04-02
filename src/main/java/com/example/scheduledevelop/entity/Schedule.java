package com.example.scheduledevelop.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 서버에서 적용되는 임의 번호 아이디

    @Column(nullable = false)
    private String name; // 유저이름

    private String todotitle; // 할일 제목

    private String todo; // 할일

    //BaseEntity 상속 받아서 작성일과 수정일 존재

}
