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
    @Column(name = "ex_id")
    private Long exId; //식별 id, auto increment

    @Column(nullable = false, length = 100, name = "ex_title")
    private String exTitle; //전시회 이름

    @Column(columnDefinition = "TEXT")
    private String description; //전시회 설명

    @Column(nullable = false, name = "start_date")
    private LocalDate startDate; //전시회 시작일

    @Column(nullable = false, name = "end_date")
    private LocalDate endDate; //종료일

    @Column(length = 60)
    private String contact; //문의, 연락처

    @Column(nullable = false,  length = 100)
    private String location; //장소

    @Column(length = 40, name = "open_time")
    private String openTime; //이용 시간

    @Column(length = 40, name = "closed_date")
    private String closedDate; //휴무일

    @Column(length = 40)
    private String price; //가격

    @Column(length = 100)
    private String image; //이미지

    @Column(length = 100)
    private String url; //전시회 예약 사이트 url

}
