package com.example.guestbook;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestbookController {
    private final GuestbookRepository repo;

    public GuestbookController(GuestbookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/api/entries")
    public List<GuestbookEntry> list() {
        return repo.findAll();
    }

    @PostMapping("/api/entries")
    public ResponseEntity<?> add(@RequestParam String name, @RequestParam String message) {
        if (!StringUtils.hasText(name) || !StringUtils.hasText(message)) {
            return ResponseEntity.badRequest().body("name/message is required");
        }
        if (name.length() > 100 || message.length() > 2000) {
            return ResponseEntity.badRequest().body("too long");
        }
        repo.insert(name.trim(), message.trim());
        return ResponseEntity.ok().build();
    }
}
