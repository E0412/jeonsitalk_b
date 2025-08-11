package com.jeonsitalk.community.repository;

import com.jeonsitalk.community.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommRepository extends JpaRepository<Community, Long> {
}
