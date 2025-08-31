package com.jeonsitalk.member.service;

import com.jeonsitalk.member.dto.RegisterDto;
import com.jeonsitalk.member.entity.Member;
import com.jeonsitalk.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


}
