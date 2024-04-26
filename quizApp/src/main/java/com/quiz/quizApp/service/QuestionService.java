package com.quiz.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quizApp.dao.QuestionDao;
import com.quiz.quizApp.model.Questions;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Questions>> getAllQuestions() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.getQuestionsByCategory(category),HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return new ResponseEntity<>(questionDao.getQuestionsByCategory(category),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestions(Questions questions) {
		// TODO Auto-generated method stub
		questionDao.save(questions);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
	}
	
	
}

