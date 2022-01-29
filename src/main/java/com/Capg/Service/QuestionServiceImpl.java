package com.Capg.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Capg.Exception.QuestionNotFoundException;
import com.Capg.Model.Question;
import com.Capg.Repositary.QuestionRepositary;


@Service
public class QuestionServiceImpl implements QuestionService
{
	@Autowired
	private QuestionRepositary questionRepositary;


	@Override
	public ResponseEntity<List<Question>> getQuestions()
	{
		List<Question> questions = questionRepositary.findAll();
		return ResponseEntity.ok().body(questions);
	}

	@Override
	public ResponseEntity<Question> getQuestionById(int q_id) throws QuestionNotFoundException 
	{
		Question question = questionRepositary.findById(q_id).orElseThrow(() -> new QuestionNotFoundException("Q_ID :: " + q_id + " Not Found"));
		return ResponseEntity.ok().body(question);
	}

	@Override
	public ResponseEntity<Question> updateQuestionById(int q_id, Question question) throws QuestionNotFoundException
	{
		Question newQuestion = questionRepositary.findById(q_id).orElseThrow(() -> new QuestionNotFoundException("Q_ID:: " + q_id + " Not Found"));
		newQuestion.setQ_name(question.getQ_name());
		newQuestion.setOption_a(question.getOption_a());
		newQuestion.setOption_b(question.getOption_b());
		newQuestion.setOption_c(question.getOption_c());
		newQuestion.setOption_d(question.getOption_d());
		final Question updatedQuestion = questionRepositary.save(newQuestion);
		return ResponseEntity.ok().body(updatedQuestion);
	}

	@Override
	public ResponseEntity<Question> deleteQuestionById(int q_id) throws QuestionNotFoundException
	{
		Question question = questionRepositary.findById(q_id).orElseThrow(() -> new QuestionNotFoundException("Q_ID :: " + q_id + " Not Found"));
		questionRepositary.deleteById(q_id);
		return ResponseEntity.ok().body(question);
	}

}
