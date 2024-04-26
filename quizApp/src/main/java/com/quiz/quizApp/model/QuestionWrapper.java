package com.quiz.quizApp.model;

import lombok.Data;

@Data
public class QuestionWrapper {
	
	public QuestionWrapper(Integer id, String category, String questionTitle, String option1, String option2,
			String option3) {
		super();
		this.id = id;
		this.category = category;
		this.questionTitle = questionTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
	}
	private Integer id;
	private String category;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;

}
