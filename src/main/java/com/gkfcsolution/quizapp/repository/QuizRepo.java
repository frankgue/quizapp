package com.gkfcsolution.quizapp.repository;

import com.gkfcsolution.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2025 at 12:58
 * File: QuizRepo.java.java
 * Project: quizapp
 *
 * @author Frank GUEKENG
 * @date 06/08/2025
 * @time 12:58
 */
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
