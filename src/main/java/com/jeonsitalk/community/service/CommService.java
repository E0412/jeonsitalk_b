package com.jeonsitalk.community.service;

import com.jeonsitalk.community.dto.CommModifyDto;
import com.jeonsitalk.community.entity.Community;
import java.util.List;
import java.util.Optional;

//service를 인터페이스와 구현 클래스로 분리
public interface CommService {

    //게시글 조회
    public List<Community> communityList();

    //게시글 단건 조회
    public Optional<Community> communityDetail(Long id); 

    //게시글 작성 register or write
    public Community communityWrite(Community write);

    //게시글 수정
    public Optional<Community> communityModify(Long id, CommModifyDto modifyDto);

    //게시글 삭제
    public boolean communityDelete(Long id);

}
