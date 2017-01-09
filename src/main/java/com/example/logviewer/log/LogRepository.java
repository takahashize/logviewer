package com.example.logviewer.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByEntryLike(@Param("entry") String entry);
    List<Log> findByEntryStartsWith(@Param("entry") String entry);
}
