package com.Capg.Service;
import java.util.List;
import org.springframework.http.ResponseEntity;

import com.Capg.Exception.QuestionNotFoundException;
import com.Capg.Model.Question;
public interface QuestionService 
{
	public ResponseEntity<List<Question>> getQuestions();
	public ResponseEntity<Question> getQuestionById(int q_id) throws QuestionNotFoundException;
	public ResponseEntity<Question> updateQuestionById(int q_id, Question question) throws QuestionNotFoundException;
	public ResponseEntity<Question> deleteQuestionById(int q_id) throws QuestionNotFoundException;
}








