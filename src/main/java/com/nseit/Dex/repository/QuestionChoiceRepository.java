package com.nseit.Dex.repository;

import com.nseit.Dex.model.QuestionChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionChoiceRepository extends JpaRepository<QuestionChoice, Integer> {
    Optional<QuestionChoice> findByChoiceName(String choiceName);
}
