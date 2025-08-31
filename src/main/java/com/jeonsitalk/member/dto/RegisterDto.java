package com.jeonsitalk.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

    private String memberId; //아이디

    private String nickname; //닉네임

    private String password; //비밀번호

    private String email; //이메일

}
