package com.casosemestral.edutech.repository;

import com.casosemestral.edutech.model.BackupLog;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackupLogRepository extends JpaRepository<BackupLog, Log> {
}
