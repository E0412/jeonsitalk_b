package com.jeonsitalk.community.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Column(name = "post_id")
    private Long postId; //게시글 식별번호

//    @Column(nullable = false)
    @Column(length = 50)
    private String title; //글제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; //내용

    //issue : 작성 날짜가 자동 등록이 안됨 수정 필요
    @Column(updatable = false)
    private LocalDateTime created; //글 작성 날짜

    private Integer views; //조회수

}
