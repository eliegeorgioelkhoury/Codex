package com.mymonty.business.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource(DataSourceProperties properties) {
        ensureDatabaseExists(properties);

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setDriverClassName(properties.getDriverClassName());
        return dataSource;
    }

    private void ensureDatabaseExists(DataSourceProperties properties) {
        String jdbcUrl = properties.getUrl();
        String databaseName = extractDatabaseName(jdbcUrl);
        if (databaseName == null || databaseName.isBlank()) {
            return;
        }

        String adminUrl = jdbcUrl.replace("databaseName=" + databaseName, "databaseName=master");
        String sql = "IF DB_ID(?) IS NULL EXEC('CREATE DATABASE [' + ? + ']')";

        try (Connection connection = DriverManager.getConnection(adminUrl, properties.getUsername(), properties.getPassword());
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, databaseName);
            statement.setString(2, databaseName);
            statement.execute();
        } catch (Exception exception) {
            throw new IllegalStateException("Failed to initialize SQL Server database: " + databaseName, exception);
        }
    }

    private String extractDatabaseName(String jdbcUrl) {
        if (jdbcUrl == null || !jdbcUrl.contains("databaseName=")) {
            return null;
        }

        String[] split = jdbcUrl.split("databaseName=");
        if (split.length < 2) {
            return null;
        }

        String tail = split[1];
        int separatorIndex = tail.indexOf(';');
        return separatorIndex >= 0 ? tail.substring(0, separatorIndex) : tail;
    }
}
