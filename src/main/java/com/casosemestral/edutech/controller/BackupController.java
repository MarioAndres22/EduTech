package com.casosemestral.edutech.controller;

import com.casosemestral.edutech.service.BackupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/backup")
@RequiredArgsConstructor
public class BackupController {

    private final BackupService backupService;

    public String respaldar() {
        return backupService.backupDatabase();
    }

    @PostMapping("/restaurar")
    public String restaurar(@RequestParam String filename) {
        return backupService.restoreDatabase(filename);
    }
}
