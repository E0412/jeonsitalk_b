package com.jeonsitalk.community.service;

import com.jeonsitalk.community.dto.CommModifyDto;
import com.jeonsitalk.community.entity.Community;
import com.jeonsitalk.community.repository.CommRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommServiceImpl implements CommService {

    private final CommRepository commRepository;

    //게시글 조회
    @Override
    public List<Community> communityList() {
        return commRepository.findAll();
    }

    //게시글 상세 조회
    @Override
    public Optional<Community> communityDetail(Long id) {
        return commRepository.findById(id);
    }
    
    //게시글 작성
    @Override
    public Community communityWrite(Community write) {
        return commRepository.save(write);
    }

    //게시글 수정
    @Override
    public Optional<Community> communityModify(Long id, CommModifyDto modifyDto) {
        return commRepository.findById(id).map(updates -> {
            updates.setTitle(modifyDto.getTitle());
            updates.setContent(modifyDto.getContent());
            updates.setProfileImg(modifyDto.getProfileImg());
            updates.setName(modifyDto.getName());
                return commRepository.save(updates);
        });
    }

    //게시글 삭제
    @Override
    public boolean communityDelete(Long id) {
        return commRepository.findById(id).map(deletes -> {
            commRepository.deleteById(id);
                return true;
        }).orElse(false);
    }

}
