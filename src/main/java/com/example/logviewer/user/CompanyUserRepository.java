package com.example.logviewer.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyUserRepository extends JpaRepository<CompanyUser, String> {
}
