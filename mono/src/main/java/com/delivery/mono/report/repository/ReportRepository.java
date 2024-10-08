package com.delivery.mono.report.repository;

import com.delivery.mono.report.domain.Report;
import com.delivery.mono.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {

    @Query("SELECT r FROM Report r WHERE r.user = :user AND r.isDeleted = false")
    Page<Report> findAllByUserAndIsDeletedFalse(User user, Pageable pageable);

    @Query("SELECT r FROM Report r WHERE r.isDeleted = false AND r.title LIKE %:text%")
    Page<Report> findByIsDeletedFalseAndTitleContaining(String text, Pageable pageable);

    @Query("SELECT r FROM Report r WHERE r.isDeleted = false")
    Page<Report> findAllByIsDeletedFalse(Pageable pageable);
}
