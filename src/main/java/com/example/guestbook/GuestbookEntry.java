package com.example.guestbook;

public record GuestbookEntry(Long id, String name, String message, String createdAt) {}
