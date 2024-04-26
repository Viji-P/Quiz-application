package com.quiz.quizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizApp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
