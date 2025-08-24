package com.jeonsitalk.community.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//수정시 null과 여백을 검증하는 dto
public class CommModifyDto {

    @NotBlank //not null과 여백만 입력 불가
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String profileImg;

    @NotBlank
    private String name;

}
