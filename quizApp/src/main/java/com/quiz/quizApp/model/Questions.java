package com.quiz.quizApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="quiz")
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String category;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String rightAnswer;
	private String difficultylevel;

}

