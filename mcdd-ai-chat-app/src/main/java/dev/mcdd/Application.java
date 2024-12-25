package dev.mcdd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(String token) {
        log.info("Verify token: {}", token);
        if ("success".equals(token)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
