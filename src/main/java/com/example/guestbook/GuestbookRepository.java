package com.example.guestbook;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestbookRepository {
    private final JdbcTemplate jdbc;

    public GuestbookRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<GuestbookEntry> findAll() {
        return jdbc.query(
            "SELECT id, name, message, created_at FROM guestbook_entry ORDER BY id DESC",
            (rs, i) -> new GuestbookEntry(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("message"),
                rs.getTimestamp("created_at").toInstant().toString()
            )
        );
    }

    public int insert(String name, String message) {
        return jdbc.update(
            "INSERT INTO guestbook_entry(name, message) VALUES (?,?)",
            name, message
        );
    }
}
