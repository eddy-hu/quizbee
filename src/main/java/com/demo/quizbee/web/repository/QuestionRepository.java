package com.demo.quizbee.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quizbee.web.dto.QuestionDTO;

@Repository("questionRepository")
public interface QuestionRepository extends JpaRepository<QuestionDTO, Long> {

}
