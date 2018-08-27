package com.demo.quizbee.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quizbee.web.dto.MarkupDTO;


@Repository("markupRepository")
public interface MarkupRepository extends JpaRepository<MarkupDTO, Long> {

}
