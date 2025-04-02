package com.example.scheduledevelop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 임의로 아이디 값을 받음
    private Long id; // 서버에서 적용되는 임의 번호 아이디

    @Column(nullable = false, unique = true) // null 불가, 같은 이메일 사용 방지를 위한 unique설정
    private String email; // 유저 이메일

    @Column(nullable = false) //null 불가
    private String password; //비밀 번호

    //BaseEntity 상속 받아서 작성일과 수정일 존재
}
