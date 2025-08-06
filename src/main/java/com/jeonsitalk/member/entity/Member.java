package com.jeonsitalk.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String memberId; //로그인 아이디

    private String name; //닉네임

    private String email; //이메일

    private String password; //비밀번호

    private String nickname; //닉네임, 선택요소지만 랜덤으로 값을 넣을예정

//   private String userInfo 유저 소개글 - 마이페이지 구현시 필요
//    private String userFile 유저 프로필 사진 - 파일 업로드 구현시 필요

}
