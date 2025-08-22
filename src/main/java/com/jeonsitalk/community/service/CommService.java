package com.jeonsitalk.community.service;

import com.jeonsitalk.community.entity.Community;
import com.jeonsitalk.community.repository.CommRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommService {

    private final CommRepository commRepository;

    //게시글 조회
    public List<Community> communityList() {
        return commRepository.findAll();
    }

    //게시글 단건 조회
    public Optional<Community> communityDetail(Long id) {
        return commRepository.findById(id);
    }

    //게시글 작성 register or write
    public Community communityWrite(Community write) {
        return commRepository.save(write);
    }

    //게시글 수정
    public Optional<Community> communityModify(Long id, Community community) {

        return commRepository.findById(id).map(list -> {
                        list.setTitle(community.getTitle());
                        list.setContent(community.getContent());
                        list.setProfileImg(community.getProfileImg());
                        list.setName(community.getName());
                        return commRepository.save(list);
        });
    }

    //게시글 삭제
    public boolean communityDelete(Long id) {

        return commRepository.findById(id).map(delete -> {
                        commRepository.delete(delete);
                        return true;
        }).orElse(false);
    }

}
