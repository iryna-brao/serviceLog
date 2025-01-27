package com.example.service_log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @PostMapping("/log")
    public ResponseEntity<Void> logRequest(@RequestBody String logMessage) {
        // Check if mail isn't empty
        if (logMessage == null || logMessage.isBlank()) {
            logger.warn("Received empty log message.");
            return ResponseEntity.badRequest().build();
        }

        // Logging received message in console
        logger.info("Received log message: {}", logMessage);

        // Return HTTP 200 OK
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Logging of error
        logger.error("Error occurred: {}", ex.getMessage());
        return ResponseEntity.status(500).body("An error occurred while processing the log request.");
    }
}
