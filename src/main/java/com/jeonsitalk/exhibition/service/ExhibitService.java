package com.jeonsitalk.exhibition.service;

import com.jeonsitalk.exhibition.entity.Exhibition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ExhibitService {

    //전시회 전체 조회, 페이지네이션 적용
    public Page<Exhibition> exLists(Pageable pageable);

    //전시회 상세 조회
    public Optional<Exhibition> exListDetail(Long id);

}
