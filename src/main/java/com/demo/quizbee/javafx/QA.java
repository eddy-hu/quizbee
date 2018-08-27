package com.demo.quizbee.javafx;

public class QA extends QARequirements {
	/**
	 * 
	 */	

	private String question, category, explanation;
	private String[] answers;
	private int points,correctAnswer, difficulty;
	private boolean result;
	
	
	public QA(String question, String[] answers, String category, String explanation, int difficulty, int points, int correctAnswer){
		setQuestion(question);
		setAnswers(answers);
		setCategory(category);
		setExplanation(explanation);
		setDifficulty(difficulty);
		setPoints(points);
		setCorrectAnswerNumber(correctAnswer);
		
	}

	@Override
	public String getQuestion() {
		return question;
		
	}

	@Override
	public void setQuestion(String question) {
		this.question = question;

	}

	@Override
	public String[] getAnswers() {
		return answers;
	}

	@Override
	public void setAnswers(String[] answers) {
		for(int i=0 ; i < answers.length; i++)
		this.answers[i]= answers[i];
			
		
		}

	

	@Override
	public String getExplanation() {
		return explanation;
	}

	@Override
	public void setExplanation(String question) {
		this.explanation = question;

	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public void setCategory(String category) {
		this.category = category;

	}

	@Override
	public int getDifficulty() {
		return difficulty;
		
	}

	@Override
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;

	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;

	}

	@Override
	public int getCorrectAnswerNumber() {
		return correctAnswer;
	}

	@Override
	public void setCorrectAnswerNumber(int correctAnswer) {
		this.correctAnswer = correctAnswer;

	}

	@Override
	public boolean isCorrect() {
		return result;
	}

	@Override
	public void setResult(boolean b) {
		this.result = b;

	}

}