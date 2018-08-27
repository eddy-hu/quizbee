package com.demo.quizbee.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quizbee.web.dto.AnswerDTO;


@Repository("answerRepository")
public interface AnswerRepository extends JpaRepository<AnswerDTO, Long> {

}
