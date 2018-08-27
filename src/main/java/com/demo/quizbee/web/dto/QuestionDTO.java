package com.demo.quizbee.web.dto;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionDTO {
	private String question, explanation;
	private Set<AnswerDTO> answers;
	private int points,correctAnswer, difficulty;
	private boolean result;
	
}