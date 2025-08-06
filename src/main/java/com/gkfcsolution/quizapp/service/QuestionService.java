package com.gkfcsolution.quizapp.service;

import com.gkfcsolution.quizapp.model.Question;
import com.gkfcsolution.quizapp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 11:25
 * File: null.java
 * Project: quizapp
 *
 * @author Frank GUEKENG
 * @date 06/08/2025
 * @time 11:25
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        Question savedQuestion = questionRepo.save(question);
        return new ResponseEntity<>("Question added successfully with ID: " + savedQuestion.getId(), HttpStatus.CREATED);
    }

    public String deleteQuestion(int id) {
        if (!questionRepo.existsById(id)) {
            return "Question with ID: " + id + " does not exist.";
        }
        questionRepo.deleteById(id);
        return "Question deleted successfully with ID: " + id;
    }
}
