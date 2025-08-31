package com.jeonsitalk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    //비밀번호 암호화
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //csrf 비활성화, 주로 api 환경에서 설정함
        http.csrf((auth) -> auth.disable());

        //http basic 인증방식 비활성화 
        http.httpBasic((auth) -> auth.disable());
        
        //form login 비활성화
        http.formLogin((auth) -> auth.disable());
        
        //요청 경로에 대한 인가 설정
        http.authorizeHttpRequests((auth) -> auth
                //requestMatchers 설정 추가하기
                .requestMatchers("/", "/api/member/register").permitAll()
                .anyRequest().permitAll() //요청 허용
        );
        
        return http.build();
    }
    
}
