package com.nseit.Dex.repository;

import com.nseit.Dex.model.CandidateHistory;
import com.nseit.Dex.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateHistoryRepository extends JpaRepository<CandidateHistory, Integer> {
    List<CandidateHistory> findBySubjects(Subjects subjects);
}
