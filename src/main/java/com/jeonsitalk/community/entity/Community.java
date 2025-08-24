package com.jeonsitalk.community.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_num")
    private Long postId; //게시글 식별번호

    @Column(length = 50)
    private String title; //글 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; //내용

    //issue : insertable을 false 수정하여 해결
    @Column(updatable = false, insertable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created; //글 작성 날짜

    @Column(insertable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer views; //조회수

    //임시 컬럼 -> 로그인 및 마이페이지 제작시 fk와 dto로 참조
    @Column(length = 100, name = "profile_img")
    private String profileImg; //프로필 사진

    @Column(length = 20)
    private String name; //닉네임

}
