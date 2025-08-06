package com.gkfcsolution.quizapp.controller;

import com.gkfcsolution.quizapp.model.QuestionWrapper;
import com.gkfcsolution.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 12:50
 * File: null.java
 * Project: quizapp
 *
 * @author Frank GUEKENG
 * @date 06/08/2025
 * @time 12:50
 */
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numberOfQuestions,
                                             @RequestParam String title) {
        return quizService.createQuiz(category, numberOfQuestions, title);

    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);
    }
}
