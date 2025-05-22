package com.casosemestral.edutech.service;

import com.casosemestral.edutech.model.BackupLog;
import com.casosemestral.edutech.repository.BackupLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BackupService {

    private final BackupLogRepository backupLogRepository;

    public String backupDatabase() {
        String filename = "backup_" + System.currentTimeMillis() + ".sql";
        String command = "pg_dump -U usuario -h localhost -d basedatos -f backups/" + filename;

        return runCommand(command, filename, "BACKUP");
    }

    public String restoreDatabase(String filename) {
        String command = "psql -U usuario -h localhost -d basedatos -f backups/" + filename;

        return runCommand(command, filename, "RESTORE");
    }

    private String runCommand(String command, String filename, String action) {
        boolean success = false;
        StringBuilder output = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            success = (process.exitValue() == 0);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    success ? process.getInputStream() : process.getErrorStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

        } catch (IOException | InterruptedException e) {
            output.append(e.getMessage());
        }

        backupLogRepository.save(BackupLog.builder()
                .filename(filename)
                .timestamp(LocalDateTime.now())
                .action(action)
                .success(success)
                .details(output.toString())
                .build());

        return success ? "Operación completada: " + action : "Error: " + output;
    }
}

