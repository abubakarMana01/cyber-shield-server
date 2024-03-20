package com.project.cybershield.repository;

import com.project.cybershield.model.entity.Record;
import com.project.cybershield.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findAllByUser(User user);
}
