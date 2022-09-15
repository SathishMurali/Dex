package com.nseit.Dex.repository;

import com.nseit.Dex.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {
    Optional<Questions> findByQuestion(String question);
}
