package com.example.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class GuestbookApplication {
    public static void main(String[] args) {
        Console console = System.console();

        String host = (console != null) ? console.readLine("DB Host [localhost]: ") : "";
        if (host == null || host.isBlank()) host = "localhost";

        String port = (console != null) ? console.readLine("DB Port [3306]: ") : "";
        if (port == null || port.isBlank()) port = "3306";

        String db = (console != null) ? console.readLine("DB Name [guestbook]: ") : "";
        if (db == null || db.isBlank()) db = "guestbook";

        String user = (console != null) ? console.readLine("DB User [guest]: ") : "";
        if (user == null || user.isBlank()) user = "guest";

        char[] pwChars = (console != null) ? console.readPassword("DB Password [guestpw]: ") : null;
        String pass = (pwChars == null || pwChars.length == 0) ? "guestpw" : new String(pwChars);

        System.setProperty("DB_HOST", host);
        System.setProperty("DB_PORT", port);
        System.setProperty("DB_NAME", db);
        System.setProperty("DB_USER", user);
        System.setProperty("DB_PASS", pass);

        SpringApplication.run(GuestbookApplication.class, args);
    }
}
