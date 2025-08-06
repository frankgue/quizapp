package com.gkfcsolution.quizapp.repository;

import com.gkfcsolution.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2025 at 11:27
 * File: null.java
 * Project: quizapp
 *
 * @author Frank GUEKENG
 * @date 06/08/2025
 * @time 11:27
 */
@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numberOfQuestions);
}
