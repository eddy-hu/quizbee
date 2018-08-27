package com.demo.quizbee.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quizbee.web.dto.ResultDTO;


@Repository("resultRepository")
public interface ResultRepository extends JpaRepository<ResultDTO, Long> {

}
