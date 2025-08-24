package com.jeonsitalk.community.controller;

import com.jeonsitalk.community.dto.CommModifyDto;
import com.jeonsitalk.community.entity.Community;
import com.jeonsitalk.community.service.CommService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class CommController {

    private final CommService commService;

    //service 계층을 추가하여 분리
    //ResponseEntity를 사용하여 리팩토링, talend API로 테스트 완료
    //커뮤니티 글 전체 조회
    @GetMapping("/lists")
    public ResponseEntity<List<Community>> communityList() {
        List<Community> lists =  commService.communityList();
        return ResponseEntity.ok().body(lists); //게시글이 있는경우 200 ok와 body에 값 반환
    }

    //글 1개 조회(상세)
    @GetMapping("/lists/{id}")
    public ResponseEntity<Community> communityDetail(@PathVariable("id") Long id) {
        Optional<Community> lists = commService.communityDetail(id);
        return lists.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); //찾은 경우 200ok, 못 찾은 경우 404 not found
    }

    //글 작성
    @PostMapping("/writes")
    public ResponseEntity<Community> communityWrite(@RequestBody Community community) {
        Community write = commService.communityWrite(community);
        return ResponseEntity.ok().body(write); //201 created()도 고려
    }

    //글 수정
    @PutMapping("/lists/{id}")
    public ResponseEntity<Community> communityUpdate(@Valid @RequestBody CommModifyDto modifyDto, @PathVariable("id") Long id) {
        Optional<Community> modify = commService.communityModify(id, modifyDto);
        return modify.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //글 삭제
    @DeleteMapping("/lists/{id}")
    public ResponseEntity<Community> communityDelete(@PathVariable("id") Long id) {
            boolean delete = commService.communityDelete(id);
            return  delete ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
