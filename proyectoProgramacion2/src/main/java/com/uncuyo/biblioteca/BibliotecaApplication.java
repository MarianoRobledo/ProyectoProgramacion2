package com.uncuyo.biblioteca;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

@SpringBootApplication
public class BibliotecaApplication {

    private static final Logger log = LoggerFactory.getLogger(BibliotecaApplication.class);

    @Value("${biblioteca.db.reset-on-startup:false}")
    private boolean resetOnStartup;

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    // Initialize DB schema on startup if DB file missing
    @Bean
    public CommandLineRunner initDatabase(DataSource dataSource) {
        return args -> {
            // Ensure parent directory for SQLite file exists and reset DB file to start clean
            java.nio.file.Path dbDir = java.nio.file.Paths.get("database");
            try {
                java.nio.file.Files.createDirectories(dbDir);
            } catch (Exception e) {
                log.warn("Could not ensure database directory: {}", e.getMessage());
            }

            java.nio.file.Path dbFile = dbDir.resolve("biblioteca.db");
            boolean wiped = false;
/*
            // Try to delete the file
            try {
                boolean deleted = java.nio.file.Files.deleteIfExists(dbFile);
                if (deleted) {
                    wiped = true;
                    log.info("Deleted existing DB file to perform reset: {}", dbFile.toAbsolutePath());
                } else {
                    log.info("No existing DB file to delete: {}", dbFile.toAbsolutePath());
                }
            } catch (Exception ex) {
                log.warn("Could not delete existing DB file (it may be locked): {}", ex.getMessage());
            }
*/
            // If file deletion didn't occur, try to wipe all tables via JDBC
            if (!wiped) {
                log.info("Attempting in-database wipe (DROP TABLE) since file delete did not occur or DB file exists");
                String[] tables = new String[] {
                        "prestamo", "ejemplar", "libro", "biblioteca", "bibliotecario", "persona", "cliente", "editorial", "autor"
                };
                try (java.sql.Connection conn = dataSource.getConnection(); java.sql.Statement stmt = conn.createStatement()) {
                    // disable foreign keys enforcement while dropping
                    try { stmt.execute("PRAGMA foreign_keys = OFF"); } catch (Exception ignore) {}
                    for (String t : tables) {
                        try {
                            stmt.executeUpdate("DROP TABLE IF EXISTS " + t);
                            log.debug("Dropped table if existed: {}", t);
                        } catch (Exception ex) {
                            log.warn("Could not drop table {}: {}", t, ex.getMessage());
                        }
                    }
                    try { stmt.execute("PRAGMA foreign_keys = ON"); } catch (Exception ignore) {}
                    wiped = true;
                    log.info("In-database wipe finished");
                } catch (Exception ex) {
                    log.warn("In-database wipe failed: {}", ex.getMessage());
                }
            }

            // Run schema.sql then data.sql to recreate schema and load seed data
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(new ClassPathResource("schema.sql"));
            populator.addScript(new ClassPathResource("data.sql"));
            DatabasePopulatorUtils.execute(populator, dataSource);
        };
    }
}
