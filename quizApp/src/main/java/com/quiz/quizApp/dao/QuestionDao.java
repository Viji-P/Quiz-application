package com.quiz.quizApp.dao;



import org.springframework.stereotype.Repository;

import com.quiz.quizApp.model.Questions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer>{

	List<Questions> getQuestionsByCategory(String category);

	@Query(value = "SELECT * FROM quiz q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Questions> findRandomQuestionsByCategory( String category, int numQ);


	

}
