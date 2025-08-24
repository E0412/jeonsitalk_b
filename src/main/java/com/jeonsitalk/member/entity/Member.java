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

    @Column(unique = true, name = "member_id", nullable = false, updatable = false, length = 20)
    private String memberId; //로그인 아이디, 중복x

    @Column(nullable = false, length = 20)
    private String nickname; //닉네임

    @Column(nullable = false, length = 40)
    private String password; //비밀번호

    @Column(unique = true, nullable = false, length = 50)
    private String email; //이메일

    //관리자, 일반 사용자로 구분
    @Enumerated(EnumType.STRING) //문자열로 읽어옴
    @Column(nullable = false, insertable = false, columnDefinition = "ENUM('MEMBER', 'ADMIN') DEFAULT 'MEMBER'")
    private MemberRole role;

    @Column(length = 100, name = "member_img")
    private String memberImg; //프로필 사진

}
