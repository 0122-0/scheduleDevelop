package com.example.scheduledevelop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 임의로 아이디값을 받음.
    private Long id; // 서버에서 적용되는 임의 번호 아이디

    @Column(nullable = false) //null을 하게되면 의미가 없어지는것이니 안됨.
    private String todotitle; // 할일 제목

    @Column(columnDefinition = "longtext")
    private String todo; // 할일

    //BaseEntity 상속 받아서 작성일과 수정일 존재
    @ManyToOne //연관관계
    @JoinColumn(name = "user_id") // 유저의 id로 유저 고유 식별자 연관관계설정
    private User user; // 유저 고유 식별자
}
