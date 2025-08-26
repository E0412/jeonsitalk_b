package com.jeonsitalk.exhibition.repository;

import com.jeonsitalk.exhibition.entity.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitRepository extends JpaRepository<Exhibition, Long> {

}
