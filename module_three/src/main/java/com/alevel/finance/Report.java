package com.alevel.finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.time.Instant;
import java.util.Properties;

public class Report {

    private static final Logger log = LoggerFactory.getLogger(Report.class);

    public static void main(String[] args) {

        Properties props = loadProperties();

        String url = props.getProperty("url");

        log.info("Connecting to {}", url);

        String fileName = "docket.csv";

        try (Connection connection = DriverManager.getConnection(url, props)) {

            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("SELECT current_timestamp;");

                if (resultSet.next()) {
                    Timestamp timestamp = resultSet.getTimestamp(1);
                    log.info("Database timestamp {}", timestamp);
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

                log.info("Creating new file {}", fileName);

                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT clients.name, operations.operation_name, operations.operation_cost, operations.modified_at " +
                                "WHERE clients.modified_at=operations.modified_at;"
                )) {
                    ResultSet resultSet = statement.executeQuery();

                    writer.write("user_name, operation_name, operation_cost, modified_at");
                    log.info("Writing headers");

                    while (resultSet.next()) {

                        String user = resultSet.getString(
                                "name");

                        String operationName = resultSet.getString(
                                "operation_name");

                        BigDecimal operationCost = BigDecimal.valueOf(Long.parseLong(
                                resultSet.getString("operation_cost")));

                        Instant modifiedAt = Instant.parse(resultSet.getTime(
                                "modified_at").toString());

                        String formatter = String.format("\"%s,%s,\",%.3s,%s"
                                , user, operationName, operationCost, modifiedAt);

                        writer.newLine();
                        writer.write(formatter);

                        log.info("Added info: operation_name {}, operation_cost {}, modified_at {}"
                                , operationName, operationCost, modifiedAt);
                    }
                }
            }
        } catch (SQLException | IOException e) {
            log.info("Can't connect to {}. Throwing RuntimeException {}", url, e);
            throw new RuntimeException(e);
        }
    }

    private static Properties loadProperties() {

        Properties props = new Properties();

        try (InputStream input = Report.class.getResourceAsStream("finance.properties")) {
            log.info("Loading properties");
            props.load(input);
        } catch (IOException e) {
            log.info("Can't load properties");
            throw new UncheckedIOException(e);
        }
        return props;
    }

}
