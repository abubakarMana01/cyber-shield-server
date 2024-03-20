package com.project.cybershield.repository;

import com.project.cybershield.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByPhoneNumber(String phoneNumber);
}
