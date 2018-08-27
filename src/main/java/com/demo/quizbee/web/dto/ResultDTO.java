package com.demo.quizbee.web.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "result")
public class ResultDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private Long id;
	
	@Column(name = "quiz_name")
	private String quizName;
	
	private Set<QuestionDTO> correctQuestions;
	private Set<QuestionDTO> wrongQuestions;
	private Integer mark;
	private Integer correctNum;
	private Integer wrongNum;
	private String percent;
	
	
}
