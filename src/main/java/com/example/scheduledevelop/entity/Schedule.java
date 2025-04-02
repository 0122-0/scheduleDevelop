package com.example.scheduledevelop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 임의로 아이디값을 받음.
    private Long id; // 서버에서 적용되는 임의 번호 아이디

    @Column(nullable = false) // null은 안되지만 동명이인으로 인한 unique 설정은 하지않음
    private String name; // 유저이름

    private String todotitle; // 할일 제목

    private String todo; // 할일

    //BaseEntity 상속 받아서 작성일과 수정일 존재

}
