package com.nseit.Dex.repository;

import com.nseit.Dex.model.ExamHistory;
import com.nseit.Dex.model.ExamUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamHistoryRepository {
    List<ExamHistory> findByExamUser(ExamUser examUser);
}
