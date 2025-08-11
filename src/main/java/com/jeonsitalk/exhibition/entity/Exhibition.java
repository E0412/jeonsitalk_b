package com.jeonsitalk.exhibition.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exId; //식별 id, auto increment

    @Column(nullable = false)
    private String exTitle; //전시회 이름

    private String description; //전시회 설명

    @Column(nullable = false)
    private LocalDate startDate; //전시회 시작일

    private LocalDate endDate; //종료일

    private String contact; //문의, 연락처

    @Column(nullable = false)
    private String location; //장소

    private String openTime; //이용 시간

    private String closedDate; //휴무일

    private String price; //가격

    private String image; //이미지

}
