package com.jeonsitalk.community.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_num")
    private Long postId; //게시글 식별번호

    @Column(length = 50)
    private String title; //닉네임 -> fk로 변경예정

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; //내용

    //issue : insertable을 false 수정하여 해결
    @Column(updatable = false, insertable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created; //글 작성 날짜

    @Column(insertable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer views; //조회수

    //임시 컬럼 -> 로그인 및 마이페이지 제작시 fk로 변경
    @Column(length = 50)
    private String profileImg; //프로필 사진

    @Column(length = 50)
    private String name = "닉네임"; //닉네임

}
