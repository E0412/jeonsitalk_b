package com.jeonsitalk.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor //*
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //부여되는 아이디 auto_increment

    @Column(unique = true,  nullable = false, updatable = false)
    private String memberId; //로그인 아이디, 중복x

    @Column(nullable = false)
    private String nickname; //닉네임

    @Column(nullable = false)
    private String password; //비밀번호

    @Column(nullable = false)
    private String email; //이메일

    //관리자, 일반 사용자로 구분
    @Enumerated(EnumType.STRING) //문자열로 읽어옴
    @Column(nullable = false)
    private MemberRole role;

}
