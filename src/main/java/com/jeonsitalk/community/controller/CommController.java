package com.jeonsitalk.community.controller;

import com.jeonsitalk.community.entity.Community;
import com.jeonsitalk.community.service.CommService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class CommController {

    private final CommService commService;

    //service 계층을 추가하여 분리
    //커뮤니티 글 전체 조회
    @GetMapping("/lists")
    public List<Community> communityList() {
        return commService.communityList();
    }

    //글 1개 조회(상세)
    @GetMapping("/lists/{id}")
    public Community communityDetail(@PathVariable("id") Long id) {
        Optional<Community> lists = commService.communityDetail(id);
        return lists.orElse(null);
    }

    //글 작성
    @PostMapping("/writes")
    public Community communityWrite(@RequestBody Community community) {
        return commService.communityWrite(community);
    }

    //글 수정
    @PutMapping("/lists/{id}")
    public Community communityUpdate(@RequestBody Community community, @PathVariable("id") Long id) {
        Optional<Community> modify = commService.communityModify(id, community);
        return modify.orElseThrow();
    }

    //글 삭제
    @DeleteMapping("/lists/{id}")
    public boolean communityDelete(@PathVariable("id") Long id) {
        return commService.communityDelete(id);
    }

}
