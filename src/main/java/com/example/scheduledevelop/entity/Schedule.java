package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
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

    //Entity어노테이션이 붙은 클래스는 기본 생성자가 필요
    public Schedule() {
    }

    // id는 자동생성 되서 따로 설정하지 않음
    public Schedule(String todotitle, String todo) {
        this.todotitle = todotitle;
        this.todo = todo;

    }

    public void setUser(User user) {
        this.user = user;
    }
}
