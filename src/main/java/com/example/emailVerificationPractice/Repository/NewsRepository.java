package com.example.emailVerificationPractice.Repository;

import com.example.emailVerificationPractice.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface NewsRepository  extends JpaRepository<News,Long> {
    News findByheadName(String headname);
    void deleteByheadName(String headname);

    @Query("SELECT s FROM News s WHERE s.headName = ?1")
    Optional<News> findOptionheadName(String headname);



}
