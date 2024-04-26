package com.quiz.quizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quizApp.dao.QuestionDao;
import com.quiz.quizApp.dao.QuizDao;
import com.quiz.quizApp.model.Quiz;
import com.quiz.quizApp.model.Response;
import com.quiz.quizApp.model.QuestionWrapper;
import com.quiz.quizApp.model.Questions;


@Service
public class QuizService {
	
	
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		List<Questions> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Questions> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		
		for(Questions q:questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getCategory(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3());
			questionForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Quiz quiz = quizDao.findById(id).get();
		List<Questions> questions = quiz.getQuestions();
		int right = 0;
		int i = 0;
		for(Response response:responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
				
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

	

}
