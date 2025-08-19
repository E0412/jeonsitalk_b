package com.jeonsitalk.community.controller;

import com.jeonsitalk.community.entity.Community;
import com.jeonsitalk.community.repository.CommRepository;
import com.jeonsitalk.community.service.CommService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class CommController {

    private final CommRepository commRepository;
    private final CommService commService;

    @PostMapping("/writes")
    Community insertTestData(@RequestBody Community community) {
        return commRepository.save(community);
    }

    @GetMapping("/lists")
    List<Community> getAllCommunities() {
        return commRepository.findAll();
    }


}
