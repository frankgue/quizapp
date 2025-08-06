package com.gkfcsolution.quizapp.service;

import com.gkfcsolution.quizapp.model.Question;
import com.gkfcsolution.quizapp.model.QuestionWrapper;
import com.gkfcsolution.quizapp.model.Quiz;
import com.gkfcsolution.quizapp.repository.QuestionRepo;
import com.gkfcsolution.quizapp.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 12:56
 * File: QuizService.java.java
 * Project: quizapp
 *
 * @author Frank GUEKENG
 * @date 06/08/2025
 * @time 12:56
 */
@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numberOfQuestions);
        Quiz newQuiz = new Quiz();
        newQuiz.setTitle(title);
        newQuiz.setQuestions(questions);

        quizRepo.save(newQuiz);

        return new ResponseEntity<>(
                "Quiz created successfully with ID: " + newQuiz.getId(), HttpStatus.CREATED
        );
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz selectedQuiz = quizRepo.findById(id).orElse(null);
        if (selectedQuiz != null) {
            List<QuestionWrapper> questionForUser = new ArrayList<>();
            List<Question> selectedQuestions = selectedQuiz.getQuestions();
            for (Question question : selectedQuestions) {
                QuestionWrapper wrapper = new QuestionWrapper(
                        question.getId(),
                        question.getQuestionTitle(),
                        question.getOption1(),
                        question.getOption2(),
                        question.getOption3(),
                        question.getOption4()
                );
                questionForUser.add(wrapper);
            }
            return new ResponseEntity<>(questionForUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
