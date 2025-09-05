package com.jeonsitalk.exhibition.controller;

import com.jeonsitalk.exhibition.entity.Exhibition;
import com.jeonsitalk.exhibition.service.ExhibitService;
import com.jeonsitalk.exhibition.service.ExhibitServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/exhibition")
@RequiredArgsConstructor
public class ExhibitController {

    private final ExhibitService exhibitService; //구현체가 아닌 인터페이스 호출

    //전시회 전체 조회, 페이지는 0부터 시작 16개씩 조회
    @GetMapping("/exlists")
    public ResponseEntity<Page<Exhibition>> exLists(@PageableDefault(page = 0, size = 16, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Exhibition> exhibits = exhibitService.exLists(pageable);
        return ResponseEntity.ok().body(exhibits);
    }

    //전시회 상세 조회
    @GetMapping("/exlists/{id}")
    public ResponseEntity<Exhibition> exListDetail(@PathVariable Long id){
        Optional<Exhibition> exhibits = exhibitService.exListDetail(id);
        return exhibits.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //관리자 -> 전시회 글 작성, 수정, 삭제

}
