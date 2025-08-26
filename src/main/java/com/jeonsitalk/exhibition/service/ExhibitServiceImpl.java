package com.jeonsitalk.exhibition.service;

import com.jeonsitalk.exhibition.entity.Exhibition;
import com.jeonsitalk.exhibition.repository.ExhibitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExhibitServiceImpl implements ExhibitService {
    
    private final ExhibitRepository exhibitRepository;

    //전체 조회
    @Override
    public Page<Exhibition> exLists(Pageable pageable) {
        return exhibitRepository.findAll(pageable);
    }

    //상세 조회
    @Override
    public Optional<Exhibition> exListDetail(Long id) {
        return exhibitRepository.findById(id);
    }
    
    //관리자 영역 -> 전시회 등록, 수정, 삭제
    
}
